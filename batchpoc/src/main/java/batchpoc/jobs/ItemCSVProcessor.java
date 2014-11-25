package batchpoc.jobs;

import batchpoc.model.ItemCSV;

import org.springframework.batch.item.ItemProcessor;

public class ItemCSVProcessor implements ItemProcessor<ItemCSV, ItemCSV> {

	int nroRegistro = 0;

	@Override
	public ItemCSV process(ItemCSV itemCSV) throws Exception {
		nroRegistro++;
		itemCSV.setColumna50(String.valueOf(nroRegistro));

		return itemCSV;
	}

}
