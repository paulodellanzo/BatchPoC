package batchpoc.jobs;

import batchpoc.common.configuration.InfrastructureConfiguration;
import batchpoc.model.ETransaction;
import batchpoc.model.ItemCSV;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
@Import({InfrastructureConfiguration.class, ServicesConfiguration.class})
public class InterfaceJobConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job interfaceJob(){
        return jobs.get("interfaceJob")
                .listener(protocolListener())
                .start(step())
                .build();
    }

//    @Bean
//    public Step step2(){
//        return stepBuilderFactory.get("step2")
//                .<ItemCSV,ETransaction>chunk(1)
//                .writer(writer2())
//                .faultTolerant()
//                .skipLimit(0)
//                .skip(Exception.class)
//                .build();
//    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step")
                .<ItemCSV,ETransaction>chunk(1) //important to be one in this case to commit after every line read
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .skipLimit(0) //default is set to 0
                .skip(Exception.class)
                .build();
    }

    @Bean
    public ItemReader<ItemCSV> reader(){
        FlatFileItemReader<ItemCSV> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);//first line is title definition
        reader.setResource(new ClassPathResource("suggested-podcasts.in"));
        reader.setLineMapper(lineMapper());
        reader.open(new ExecutionContext());
        return reader;
    }

    @Bean
    public LineMapper<ItemCSV> lineMapper() {
        DefaultLineMapper<ItemCSV> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"columna01", 
        		"columna02", 
        		"columna03",
        		"columna04",
        		"columna05",
        		"columna06",
        		"columna07",
        		"columna08",
        		"columna09",
        		"columna10"
        		});

        BeanWrapperFieldSetMapper<ItemCSV> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(ItemCSV.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public ItemCSVFieldSetMapper itemCSVFieldSetMapper() {
        return new ItemCSVFieldSetMapper();
    }

    /** configure the processor related stuff */
    @Bean
    public ItemProcessor<ItemCSV, ETransaction> processor() {
        return new ItemCSVProcessor();
    }

    @Bean
    public ItemWriter<ETransaction> writer() {
        return new Writer();
    }

    @Bean
    public ItemWriter<ETransaction> writer2() {
        return new Writer2();
    }

    @Bean
    public ProtocolListener protocolListener(){
        return new ProtocolListener();
    }

}
