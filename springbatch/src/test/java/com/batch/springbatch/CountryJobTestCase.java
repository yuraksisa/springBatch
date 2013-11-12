package com.batch.springbatch;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
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
public class CountryJobTestCase {

  @Autowired
  private JobLauncher jobLauncher;
  
  @Autowired
  private Job countriesDBFromFile;
  
  @Test
  public void loadCountries() throws Exception {
	
	Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
	parameters.put("job.execution.date", new JobParameter(new java.util.Date(), true));
	
	JobParameters jobParameters = new JobParameters(parameters);  
	jobLauncher.run(countriesDBFromFile, jobParameters);  
	  
  }
	
}
