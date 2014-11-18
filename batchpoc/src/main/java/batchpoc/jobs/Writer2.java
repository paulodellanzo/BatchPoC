package batchpoc.jobs;

import batchpoc.model.ETransaction;
import batchpoc.services.BagService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Writer2 implements ItemWriter<ETransaction> {
    @Autowired
    private BagService bagService;//aca va el dao

    @Override
    public void write(List<? extends ETransaction> items) throws Exception {
        for (ETransaction etrans : items)
        {
            this.bagService.add(etrans);

        }
    }
}
