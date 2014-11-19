package batchpoc.jobs;

import batchpoc.services.BagService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DestroyTasklet implements Tasklet, InitializingBean {

    @Autowired
    BagService bagService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //Assert.notNull(bagService.getAsList(), "siempre va a existir esto");
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        this.bagService.emptyBag();

        return RepeatStatus.FINISHED;
    }

}
