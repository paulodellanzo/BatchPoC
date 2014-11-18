package batchpoc.jobs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import batchpoc.model.AjusteImpl;
import batchpoc.model.ETransaction;
import batchpoc.model.ItemCSV;

import org.springframework.batch.item.ItemProcessor;

public class ItemCSVProcessor implements ItemProcessor<ItemCSV, ETransaction> {
    
	private static final String	F_INSTANCIA				= "Columna01";
	private static final String	F_REFERENCIA			= "Columna03";				// Contrato
	private static final String	F_PUNTO					= "Columna04";
	private static final String	F_TIPO					= "Columna05";
	private static final String	F_CONTRATO_TTE			= "Columna06";
	private static final String	F_REF_PROPIA			= "Columna07";				// Secundaria
	private static final String	F_REF_EXTERNA			= "Columna08";				// Primaria
	private static final String	F_VOLUMEN				= "Columna09";
	private static final String	F_SOLICITANTE			= "Columna10";
	
	@Override
    public ETransaction process(ItemCSV itemCSV) throws Exception {
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
		
		registro = itemCSV.getColumna50();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		fecha = formatter.parse(itemCSV.getColumna02());
		punto = (String) itemCSV.getColumna04();
		referencia = (String) itemCSV.getColumna03();
		refPropia = (String) itemCSV.getColumna07();
		refExterna = (String) itemCSV.getColumna08();
		ctoTte = (String) itemCSV.getColumna06();
		tipo = (String) itemCSV.getColumna05();
		solicitante = (String) itemCSV.getColumna10();
		energia = Double.valueOf(itemCSV.getColumna09().toString());
		
		//Query de consulta del CompleteDao
		Long idTrans = null;
		
		AjusteImpl ajuste = (AjusteImpl) new AjusteImpl();
		ajuste.setTransaccionDTO(idTrans);
		ajuste.setFecha(fecha);
		ajuste.setTipo(tipo);
		ajuste.setEnergia(energia);
		Double deltaEnergia = new Double(energia.doubleValue() - energia.doubleValue());//(eneFis.doubleValue()));
		ajuste.setDeltaEnergia(deltaEnergia);
		ajuste.setFuente("INTERFAZ");
		ajuste.setFiscalEstimado("N");
		
        return new ETransaction(itemCSV);//devolver ajuste
    }
}
