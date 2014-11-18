package batchpoc.jobs;

import batchpoc.model.ETransaction;
import batchpoc.model.ItemCSV;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by pbergonzi on 13/11/14.
 */
public class ItemCSVProcessor implements ItemProcessor<ItemCSV, ETransaction> {
    @Override
    public ETransaction process(ItemCSV itemCSV) throws Exception {
    	ETransaction eTransaction = new ETransaction(itemCSV);
    	
//    	ImportacionInterfazCSV csv = new ImportacionInterfazCSV();
//		InterfazArchivoDTO interfazArchivo = JBOFacade.getInterfazFacade().getInterfazCSVImport("IMP.XLS.SOLICITADOS");
//		csv.setFileContents("\nasignado;18/10/07;@@;@ Punto modificado;R;;@@;aab;1000\n");
////		csv.setInterfazArchivo((InterfazArchivo) interfazArchivo);
//		csv.setResponsable("UTest");
//		csv.ejecutar();
		
    	return eTransaction;
    }
}
