package batchpoc;

import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    private static final String INTERFACE_JOB = "interfaceJob";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    public static void main(String[] args) throws BeansException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {
//        Log log = LogFactory.getLog(Application.class);
//
//        SpringApplication app = new SpringApplication(Application.class);
//        app.setWebEnvironment(false);
//        ConfigurableApplicationContext ctx = app.run(args);
//        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
//        Job interfaceJob = ctx.getBean(INTERFACE_JOB, Job.class);
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addDate("date", new Date())
//                .toJobParameters();
//
//        JobExecution jobExecution = jobLauncher.run(interfaceJob, jobParameters);
//
//        BatchStatus batchStatus = jobExecution.getStatus();
//
//        while(batchStatus.isRunning()){
//            log.info("*********** Still running.... **************");
//            Thread.sleep(1000);
//        }
//
//        log.info(String.format("*********** Exit status: %s", jobExecution.getExitStatus().getExitCode()));
//        JobInstance jobInstance = jobExecution.getJobInstance();
//        log.info(String.format("********* Name of the job %s", jobInstance.getJobName()));
//
//        log.info(String.format("*********** job instance Id: %d", jobInstance.getId()));
//
//        System.exit(0);
//
//    }

}