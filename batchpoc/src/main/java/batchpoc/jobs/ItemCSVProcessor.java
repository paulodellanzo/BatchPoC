package batchpoc.jobs;

import batchpoc.model.ETransaction;
import batchpoc.model.ItemCSV;

import org.springframework.batch.item.ItemProcessor;

public class ItemCSVProcessor implements ItemProcessor<ItemCSV, ETransaction> {
    @Override
    public ETransaction process(ItemCSV itemCSV) throws Exception {
        return new ETransaction(itemCSV);
    }
}
