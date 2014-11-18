package batchpoc.jobs;

import java.io.IOException;
import java.util.Properties;

import batchpoc.dao.ReaderDao;
import batchpoc.dao.ReaderDaoImpl;
import batchpoc.dao.WriterDao;
import batchpoc.dao.WriterDaoImpl;
import batchpoc.services.BagService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class ServicesConfiguration {

    @Bean
    public ReaderDao readDao(){
        return new ReaderDaoImpl();
    }

    @Bean
    public WriterDao writerDao(){
        return new WriterDaoImpl();
    }

    @Bean
    public BagService BagService(){
        return new BagService();
    }
}
