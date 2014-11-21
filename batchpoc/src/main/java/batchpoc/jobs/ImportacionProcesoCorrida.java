package batchpoc.jobs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import batchpoc.dao.CompleteDao;
import batchpoc.dao.WriterDao;
import batchpoc.model.AjusteImpl;
import batchpoc.model.EstadoInterfazCorrida;
import batchpoc.model.InterfazCorridaImpl;
import batchpoc.model.ItemCSV;
import batchpoc.model.TransaccionMarcoImpl;

public abstract class ImportacionProcesoCorrida {

	protected static final String TIPO_AJUSTE = "FIS";
	protected static final String SI = "S";
	protected static final String NO = "N";
	protected static final String TIPO_INTERFAZ = "INTERFAZ";

	protected final String BREAK_LINE = "\n";
	protected static final Long TRANSACCION_INVALIDA = new Long(-1);

	private ArrayList<String> tmAutomaticasFiscales;
	private HashMap<Long, Date> listadoTM;
	private String errorLog;

	@Autowired
	private CompleteDao completeDao;
	@Autowired
	private WriterDao writerDao;
	@Autowired
	private EntityManager entityManager;

	int registrosProcesados = 0;
	int registrosImportados = 0;
	int registrosErroneos = 0;
	int registrosRechazados = 0;
	private InterfazCorridaImpl interfazCorrida;

	public ImportacionProcesoCorrida() {
		this.tmAutomaticasFiscales = new ArrayList<>();
		this.listadoTM = new HashMap<>();
		this.interfazCorrida = new InterfazCorridaImpl();
		// interfazCorrida.setArchivoFuente(this.filecontents);
		interfazCorrida.setErrorLog("");
		// interfazCorrida.setArchivo(this.interfazArchivo);
		interfazCorrida.setArchivo(new Long(1025968));
		interfazCorrida.setResponsable("esigas");
		interfazCorrida.setDatosFechaDesde(new Date());
		interfazCorrida.setFecha(new Date());
		this.setCorrida(interfazCorrida);
		// this.getCorrida().update();
	}

	public abstract void ejecutar(ItemCSV itemCSV) throws Exception;

	public CompleteDao getCompleteDao() {
		return completeDao;
	}

	public void setCompleteDao(CompleteDao completeDao) {
		this.completeDao = completeDao;
	}

	public WriterDao getWriterDao() {
		return writerDao;
	}

	public void setWriterDao(WriterDao writerDao) {
		this.writerDao = writerDao;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Chequea que la transacción marco no esté marcada con automático fiscal
	 * (real). Ticket:9910
	 */
	protected void checkAutomaticoFiscal(TransaccionMarcoImpl data)
			throws Exception {
		if (data.getAutoFiscal().equals(SI)) {
			if (!this.getTmAutomaticasFiscales().contains(data.getAlias())) {
				this.getTmAutomaticasFiscales().add(data.getAlias());
			}
		}
	}

	public ArrayList<String> getTmAutomaticasFiscales() {
		return tmAutomaticasFiscales;
	}

	public void setTmAutomaticasFiscales(ArrayList<String> tmAutomaticasFiscales) {
		this.tmAutomaticasFiscales = tmAutomaticasFiscales;
	}

	public HashMap<Long, Date> getListadoTM() {
		return listadoTM;
	}

	public void setListadoTM(HashMap<Long, Date> listadoTM) {
		this.listadoTM = listadoTM;
	}

	public String getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	/**
	 * Informa la excepcion lanzada y el registro donde se genera, si tiene
	 * 
	 * @param mensajeException
	 * @param campos
	 * @param registro
	 */
	protected void informarExceptionRegistro(String mensajeException,
			ItemCSV campos, String registro) {
		this.getCorrida().setEstado(
				EstadoInterfazCorrida.ESTADO_FINALIZADO_ERRORES.getKey());
		// this.getProceso().setEstado(EstadosProceso.CON_ERRORES);
		if (campos != null) {
			this.getCorrida().addLineaError((campos).serializeAsCSV(), this.BREAK_LINE);
		}
		this.addErrorLog(mensajeException, registro);
	}

	public InterfazCorridaImpl getCorrida() {
		return interfazCorrida;
	}

	public void setCorrida(InterfazCorridaImpl interfazCorrida) {
		this.interfazCorrida = interfazCorrida;
	}

	public void addErrorLog(String error) {
		this.addErrorLog(error, null);
	}

	public void addErrorLog(String error, String registro) {
		if (errorLog == null) {
			errorLog = "";
		}
		if (!"".equals(errorLog)) {
			errorLog += this.BREAK_LINE;
		}
		String mensajeError = registro == null ? error : registro + ") "
				+ error;
		this.setErrorLog(errorLog + mensajeError);
	}

	public TransaccionMarcoImpl getTransaccionMarco(CompleteDao completeDao,
			Date fecha, String tipo, String punto, String referencia,
			String refPropia, String refExterna, String ctoTte, boolean b)
			throws Exception {

		// Query de consulta
		List idsVigentes = completeDao.findTransaccion(fecha, tipo, punto,
				referencia, refPropia, refExterna, ctoTte, false);

		// Envío mensaje de error según corresponda.
		if (idsVigentes.size() == 0) {
			throwTransaccionError(
					"interfaz.rutinas.transaccionInexistenteError", fecha,
					tipo, punto, referencia, refPropia, refExterna, ctoTte,
					false);
		} else if (idsVigentes.size() > 1) {
			throwTransaccionError("interfaz.rutinas.transacciones_varias",
					fecha, tipo, punto, referencia, refPropia, refExterna,
					ctoTte, false);
		} else if (TRANSACCION_INVALIDA
				.equals(((BigDecimal) idsVigentes.get(0)).longValue())) {
			throwTransaccionError("interfaz.rutinas.transaccionInvalida",
					fecha, tipo, punto, referencia, refPropia, refExterna,
					ctoTte, false);
		}
		BigDecimal idTrans = (BigDecimal) idsVigentes.get(0);

		Session session = entityManager.unwrap(Session.class);
		return (TransaccionMarcoImpl) session.load(TransaccionMarcoImpl.class, new Long(idTrans.longValue()));
	}

	protected void generarTransaccionDiaria(TransaccionMarcoImpl tmarco,
			Date fecha, Double energia) throws Exception {
		this.generarTransaccionDiaria(tmarco, fecha, energia, TIPO_INTERFAZ);
	}

	public void generarTransaccionDiaria(TransaccionMarcoImpl tmarco,
			Date fecha, Double energia, String fuente) throws Exception {
		this.generarTransaccionDiaria(tmarco, fecha, energia, fuente, TIPO_AJUSTE);
	}

	public void generarTransaccionDiaria(TransaccionMarcoImpl tmarco,
			Date fecha, Double energia, String fuente, String tipo) throws Exception {
		this.generarTransaccionDiaria(tmarco, fecha, energia, fuente, tipo, NO);
	}

	/**
	 * Crea la transaccion de volumen diario segun tmarco, fecha y energia. <br/>
	 * @param fuente: de donde proviene la generacion de la transaccion (interfaz)
	 * @param tipo: de ajuste
	 * @throws Exception
	 */
	private void generarTransaccionDiaria(TransaccionMarcoImpl tmarco,
			Date fecha, Double energia, String fuente, String tipo,
			String fiscalEstimado) throws Exception {

		Long idTransDiaria = getCompleteDao().findTransaccionDiaria(tmarco.getId(), fecha);
		Double eneFis = energia;
		
		this.generarAjuste(idTransDiaria, fecha, eneFis, null, energia, null, tipo, fiscalEstimado, fuente);
	}
	
	private void generarAjuste(Long idTransDiaria, Date fecha, Double eneFis, String unidadEnergia, Double energia, String unidadFiscal, String tipo, String fiscalEstimado, String fuente) throws Exception
	{
		try
		{
			AjusteImpl ajuste = new AjusteImpl();
			ajuste.setTransaccionDTO(idTransDiaria);
			ajuste.setFecha(fecha);
			ajuste.setTipo(tipo);
			ajuste.setEnergia(energia);
//			double factor = 1;
//			if (unidadFiscal != null && unidadEnergia != null)
//			{
//				factor = unidadFiscal.calculateFactorConversion(unidadEnergia);
//			}
//			Double deltaEnergia = new Double(energia.doubleValue() - (eneFis.doubleValue() * factor));
			Double deltaEnergia = new Double(energia.doubleValue() - eneFis.doubleValue());// (eneFis.doubleValue()));
			ajuste.setDeltaEnergia(deltaEnergia);
			ajuste.setFuente(fuente);
			if (fiscalEstimado == null || fiscalEstimado.equals(NO))
			{
				ajuste.setFiscalEstimado(NO);
			}
			else
			{
				ajuste.setFiscalEstimado(SI);
			}
			this.getWriterDao().saveAjuste(ajuste);
		}
		catch (Exception e)
		{
			this.getCorrida().setEstado(EstadoInterfazCorrida.ESTADO_ERROR_GRABAR.getKey());
			throw e;
		}
		
	}

	private void throwTransaccionError(String string, Date fecha, String tipo,
			String punto, String referencia, String refPropia,
			String refExterna, String ctoTte, boolean isCtoCargador)
			throws Exception {
		String error = makeErrorMessage(fecha, tipo, punto, referencia,
				refPropia, refExterna, ctoTte, isCtoCargador);
		throw new Exception(error);
	}

	private String makeErrorMessage(Date fecha, String tipo, String punto,
			String referencia, String refPropia, String refExterna,
			String ctoTte, boolean isCtoCargador) throws Exception {
		StringBuffer out = new StringBuffer("");
		// Fecha
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			out.append(dateFormat.format(fecha));
		}
		// Referencia
		if (referencia != null && !referencia.trim().equals("")) {
			out.append("; Ref:");
			out.append(referencia.trim());
		}
		// Recepción/Entrega
		if (tipo != null && !tipo.trim().equals("")) {
			out.append("; ");
			out.append(tipo.trim());
		}
		// Punto
		if (punto != null && !punto.trim().equals("")) {
			out.append("; Pto:");
			out.append(punto.trim());
		}
		// Contrato de transporte
		if (ctoTte != null && !ctoTte.trim().equals("")) {
			if (isCtoCargador) {
				out.append("; Car:");
				out.append(ctoTte.trim());
			} else {
				out.append("; Tte:");
				out.append(ctoTte.trim());
			}
		}
		// Referencia propia o externa
		if (refPropia != null && !refPropia.trim().equals("")) {
			out.append("; RP:");
			out.append(refPropia.trim());
		}
		if (refExterna != null && !refExterna.trim().equals("")) {
			out.append("; RE:");
			out.append(refExterna.trim());
		}
		return out.toString();
	}

}
