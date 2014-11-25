package batchpoc.jobs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import batchpoc.model.AjusteImpl;
import batchpoc.model.ItemCSV;
import batchpoc.model.TransaccionMarcoImpl;

public class ImportacionInterfazCSV extends ImportacionProcesoCorrida {

	String registro = null;
	Date fecha;
	String punto;
	String referencia;
	String refPropia;
	String refExterna;
	String ctoTte;
	String tipo;
	String solicitante;
	Double energia;
	private boolean esFiscal = true;
	private String				tipoDato = "F";
	private String				interfazFuente = "XLS.REAL";
	
	public void ejecutar(ItemCSV itemCSV) throws Exception
	{
		registro = itemCSV.getColumna50();
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy");
			fecha = formatter.parse(itemCSV.getColumna02());
			punto = itemCSV.getColumna04();
			referencia = itemCSV.getColumna03();
			refPropia = itemCSV.getColumna07();
			refExterna = itemCSV.getColumna08();
			// El reader usa string vacio si no tiene dato el campo
			refExterna = refExterna.equals("") ? null : refExterna;
			ctoTte = itemCSV.getColumna06();
			tipo = itemCSV.getColumna05();
			solicitante = itemCSV.getColumna10();
			energia = Double.valueOf(itemCSV.getColumna09());

			TransaccionMarcoImpl tmarco = this.getTransaccionMarco(
					getCompleteDao(), fecha, tipo, punto, referencia,
					refPropia, refExterna, ctoTte, false);
			this.checkAutomaticoFiscal(tmarco);

			// Grabo la Transaccion si es fiscal o real, sino la programacion
			if (this.esFiscal )
			{
				this.generarTransaccionDiaria(tmarco, fecha, energia);
			}
			else
			{
				this.generarProgramacion(tmarco, solicitante, fecha, energia);
			}
			
			registrosImportados++;
			this.getListadoTM().put(tmarco.getId(), fecha);
			
		} 
		catch (Exception e) {
			this.informarExceptionRegistro(e.getLocalizedMessage(), itemCSV, registro);
		}
//		this.getWriterDao().saveCorrida(this.getCorrida());
	}
	
	private void generarProgramacion(TransaccionMarcoImpl tmarco, String solicitante, Date fecha, Double energia) throws Exception
	{
		Long localId = null;
		// Verifico el solicitante activo, sólo para los casos de solicitudes. Este dato es obligatorio y es chequeado al cargar la corrida.
		if (this.tipoDato.equals("S"))
		{
			localId = this.getLocalizacionId(tmarco.getId(), solicitante);
			if (localId == null)
			{
				String errorMsg = "La transacción marco '" + tmarco.getAlias() + "' no posee como nominador a '" + solicitante + "'.";
				throw new Exception(errorMsg);
			}
		}
		this.saveVolProgramacion(tmarco, fecha, this.tipoDato, energia, null, null, localId, this.getCorrida().getFecha(), null, this.interfazFuente);
	}
	
	/**
	 * Chequea que una transacción dada posea sólo un nominador activo (solicitante).
	 */
	private Long getLocalizacionId(Long transId, String solicitante) throws Exception
	{
		Long out = null;
		try
		{
			if (solicitante != null && !solicitante.equals(""))
			{
				List<BigDecimal> ids = this.getCompleteDao().findLocalizacionId(transId, solicitante);
				// Envío mensaje de error según corresponda.
				if (ids.size() > 0)
				{
					out = new Long(ids.get(0).longValue());
				}
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		return out;
	}
	
}
