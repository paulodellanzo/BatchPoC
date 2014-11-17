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
        return null;
    }
}
