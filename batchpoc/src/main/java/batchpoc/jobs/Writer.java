package batchpoc.jobs;

import java.util.List;

import javax.persistence.EntityManager;

import batchpoc.dao.WriterDao;
import batchpoc.model.ETransaction;
import batchpoc.services.BagService;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Writer implements ItemWriter<ETransaction>{

    @Autowired
    private EntityManager entityManager;//aca va el dao

    @Autowired
    private BagService bagService;//aca va el dao

    @Autowired
    private WriterDao writerDao;

    @Override
    public void write(List<? extends ETransaction> items) throws Exception {
    	for (ETransaction etrans : items)
    	{
            if(!this.bagService.contains(etrans)){
                //escribo
                this.bagService.add(etrans);
            }
//            InterfazCorridaTemporal interfazCorridaTemporal = new InterfazCorridaTemporalImpl();
//            interfazCorridaTemporal.setColumna01(etrans.getItemCSV().getColumna01());
//            interfazCorridaTemporal.setColumna02(etrans.getItemCSV().getColumna02());
//            interfazCorridaTemporal.setColumna03(etrans.getItemCSV().getColumna03());
            
            
    		/*System.out.println(etrans.getItemCSV().getColumna01());
    		System.out.println(etrans.getItemCSV().getColumna02());
    		System.out.println(etrans.getItemCSV().getColumna03());
    		System.out.println(etrans.getItemCSV().getColumna04());
    		System.out.println(etrans.getItemCSV().getColumna05());
    		System.out.println(etrans.getItemCSV().getColumna06());
    		System.out.println(etrans.getItemCSV().getColumna07());
    		System.out.println(etrans.getItemCSV().getColumna08());
    		System.out.println(etrans.getItemCSV().getColumna09());*/
    		
    	}
    }


}
