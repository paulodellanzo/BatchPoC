//package batchpoc;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//public class ApplicationTests {
//
////    @Autowired
////    private JobLauncherTestUtils jobLauncherTestUtils;
//// 
////    @Test
////    public void launchJob() throws Exception {
//// 
////    //testing a job
////        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
//// 
////    //Testing a individual step
////        //JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
//// 
////        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
//// 
////    }
//
//	@Test
//	public void contextLoads() {
//		ApplicationContext context = SpringApplication.run(Application.class, "");
//        
//        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//    	Job job = (Job) context.getBean("addNewPodcastJob");
//     
//    	try {
//     
//    		JobExecution execution = jobLauncher.run(job, new JobParameters());
//    		System.out.println("Exit Status : " + execution.getStatus());
//     
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    	}
//     
//    	System.out.println("Done");
//	}
//
//}
