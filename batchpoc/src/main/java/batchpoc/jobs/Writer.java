package batchpoc.jobs;

import java.util.List;

import javax.persistence.EntityManager;

import batchpoc.dao.WriterDao;
import batchpoc.model.AjusteImpl;
import batchpoc.model.ETransaction;
import batchpoc.services.BagService;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Writer implements ItemWriter<AjusteImpl>{

    @Autowired
    private EntityManager entityManager;//aca va el dao

    @Autowired
    private BagService bagService;//aca va el dao

    @Autowired
    private WriterDao writerDao;

    @Override
    public void write(List<? extends AjusteImpl> items) throws Exception {
    	for (AjusteImpl ajuste : items)
    	{
            if(!this.bagService.contains(ajuste)){
                //escribo
                this.writerDao.saveAjuste(ajuste);
                this.bagService.add(ajuste);
            }
    		
    	}
    }


}
