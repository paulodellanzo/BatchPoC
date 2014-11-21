package batchpoc.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

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
//				this.generarProgramacion(tmarco, solicitante, fecha, energia);
			}
			
			registrosImportados++;
			this.getListadoTM().put(tmarco.getId(), fecha);
			
		} 
		catch (Exception e) {
			this.informarExceptionRegistro(e.getLocalizedMessage(), itemCSV, registro);
		}
//		this.getWriterDao().saveCorrida(this.getCorrida());
	}
	
}
