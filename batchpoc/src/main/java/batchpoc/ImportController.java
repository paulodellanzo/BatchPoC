package batchpoc;

import java.util.Date;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
public class ImportController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job interfaceJob;
	
    @RequestMapping("/csv")
    public String importCSV(@RequestParam(value="tipo", defaultValue="fiscal") String tipo) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {
        
    	Log log = LogFactory.getLog(ImportController.class);

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .addString("tipo", tipo)
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(interfaceJob, jobParameters);

        BatchStatus batchStatus = jobExecution.getStatus();

        while(batchStatus.isRunning()){
            log.info("*********** Still running.... **************");
            Thread.sleep(1000);
        }

        log.info(String.format("*********** Exit status: %s", jobExecution.getExitStatus().getExitCode()));
        JobInstance jobInstance = jobExecution.getJobInstance();
        log.info(String.format("********* Name of the job %s", jobInstance.getJobName()));

        log.info(String.format("*********** job instance Id: %d", jobInstance.getId()));

    	return "Mensaje de Exito: " + batchStatus.getBatchStatus();
    }
    
}
