package batchpoc.jobs;

import batchpoc.dao.*;
import batchpoc.services.BagService;
import batchpoc.services.BagItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public ReaderDao readDao() {
        return new ReaderDaoImpl();
    }

    @Bean
    public WriterDao writerDao() {
        return new WriterDaoImpl();
    }

    @Bean
    public CompleteDao completeDao() {
        return new CompleteDaoImpl();
    }

    @Bean
    public BagService BagService() {
        return new BagService();
    }
    
    @Bean
    public BagItemService BagItemService() {
        return new BagItemService();
    }
    
    @Bean
    public ImportacionProcesoCorrida ImportacionProcesoCorrida(){
    	return new ImportacionInterfazCSV();
    }
}
