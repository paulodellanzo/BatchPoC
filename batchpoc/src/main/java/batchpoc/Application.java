package batchpoc;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	ApplicationContext context = SpringApplication.run(Application.class, args);
        
        JobLauncher jobLauncher = (JobLauncher) context.getBean(JobLauncher.class);
    	Job job = (Job) context.getBean("addNewPodcastJob", Job.class);
     
    	try {
     
    		JobExecution execution = jobLauncher.run(job, new JobParameters());
    		System.out.println("Exit Status : " + execution.getStatus());
     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
     
    	System.out.println("Done");
    }

}
