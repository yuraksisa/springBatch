package com.batch.springbatch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations="classpath:com/batch/springbatch/config/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
public class HelloWorldJobTestCase {

	private final static Logger logger = Logger.getLogger(HelloWorldJobTestCase.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job helloWorldJob;

	@Test
	public void testLauchJob() throws Exception {
	  logger.info("Running job");	
      Map<String, JobParameter> params = new HashMap<String, JobParameter>();
      params.put("date", new JobParameter(new Date(), false));
	  JobParameters jobParameters = new JobParameters(params);
	  jobLauncher.run(helloWorldJob, jobParameters);	
	  logger.info("Job run");
	}
}
