package batchpoc.jobs;

import java.util.List;

import javax.persistence.EntityManager;

import batchpoc.dao.CompleteDao;
import batchpoc.dao.WriterDao;
import batchpoc.model.ItemCSV;
import batchpoc.services.BagItemService;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Writer implements ItemWriter<ItemCSV> {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private BagItemService bagItemService;// aca va el dao

	@Autowired
	private WriterDao writerDao;

	@Autowired
	private ImportacionProcesoCorrida importacionProceso;
	
	@Override
	public void write(List<? extends ItemCSV> items) throws Exception {
		for (ItemCSV itemCSV : items) {
			if (itemCSV != null) {
				if (!this.bagItemService.contains(itemCSV)) {
					// escribo
					this.bagItemService.add(itemCSV);

					try {
						importacionProceso.ejecutar(itemCSV);
						
					} catch (Exception e) {
						this.importacionProceso.addErrorLog(e.getLocalizedMessage());
					}
					
				}
			}

		}
	}

}
