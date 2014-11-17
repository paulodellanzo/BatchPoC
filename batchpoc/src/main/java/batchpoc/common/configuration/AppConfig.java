package batchpoc.common.configuration;

import batchpoc.jobs.InterfaceJobConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(modular=true)
public class AppConfig {

    @Bean
    public ApplicationContextFactory InterfaceJob(){
        return new GenericApplicationContextFactory(InterfaceJobConfiguration.class);
    }

}
