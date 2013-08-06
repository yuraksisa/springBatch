package com.batch.springbatch.jobs.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTask implements Tasklet {

	public RepeatStatus execute(StepContribution stepContribution,
			                    ChunkContext chunkContext)
			throws Exception {
		System.out.println("Hello World!");
		return RepeatStatus.FINISHED;
	}


	
}
