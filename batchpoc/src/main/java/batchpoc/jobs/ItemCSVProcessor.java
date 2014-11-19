package batchpoc.jobs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import batchpoc.dao.CompleteDao;
import batchpoc.model.AjusteImpl;
import batchpoc.model.ETransaction;
import batchpoc.model.ItemCSV;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemCSVProcessor implements ItemProcessor<ItemCSV, AjusteImpl> {
    @Autowired
    CompleteDao completeDao;

    private static final String	F_INSTANCIA				= "Columna01";
	private static final String	F_REFERENCIA			= "Columna03";				// Contrato
	private static final String	F_PUNTO					= "Columna04";
	private static final String	F_TIPO					= "Columna05";
	private static final String	F_CONTRATO_TTE			= "Columna06";
	private static final String	F_REF_PROPIA			= "Columna07";				// Secundaria
	private static final String	F_REF_EXTERNA			= "Columna08";				// Primaria
	private static final String	F_VOLUMEN				= "Columna09";
	private static final String	F_SOLICITANTE			= "Columna10";
	private static final String		TIPO_AJUSTE				= "FIS";
	
	@Override
    public AjusteImpl process(ItemCSV itemCSV) throws Exception {
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
		
		//registro = itemCSV.getColumna50();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		fecha = formatter.parse(itemCSV.getColumna02());
		punto = itemCSV.getColumna04();
		referencia = itemCSV.getColumna03();
		refPropia = itemCSV.getColumna07();
		refExterna = itemCSV.getColumna08();
		//El reader usa string vacio si no tiene dato el campo
		refExterna = refExterna.equals("") ? null : refExterna;
		ctoTte = itemCSV.getColumna06();
		tipo = itemCSV.getColumna05();
		solicitante = itemCSV.getColumna10();
		energia = Double.valueOf(itemCSV.getColumna09());

        //Query de consulta
		List findTransaccion = completeDao.findTransaccion(fecha,tipo,punto,referencia,refPropia,refExterna,ctoTte,false);
        BigDecimal idTrans = (BigDecimal) findTransaccion.get(0);
        Long idTransDiaria = completeDao.findTransaccionDiaria(idTrans.longValue(), fecha);
        
		AjusteImpl ajuste = new AjusteImpl();
		ajuste.setTransaccionDTO(idTransDiaria);
		ajuste.setFecha(fecha);
		ajuste.setTipo(TIPO_AJUSTE);
		ajuste.setEnergia(energia);
		Double deltaEnergia = new Double(energia.doubleValue() - energia.doubleValue());//(eneFis.doubleValue()));
		ajuste.setDeltaEnergia(deltaEnergia);
		ajuste.setFuente("INTERFAZ");
		ajuste.setFiscalEstimado("N");

        ajuste.setItemCSV(itemCSV);

        return ajuste;
    }
}
