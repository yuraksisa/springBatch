package com.batch.springbatch;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations="classpath:com/batch/springbatch/config/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
public class BicingStationLoaderJobTestCase {

	private final static Logger logger = Logger.getLogger(HelloWorldJobTestCase.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job bicingStationLoaderJob;
	private JobParameters jobParameters = new JobParameters();

	@Test
	public void testLauchJob() throws Exception {
	  logger.info("Running job");	
	  jobLauncher.run(bicingStationLoaderJob, jobParameters);	
	  logger.info("Job run");
	}
	
	
}
