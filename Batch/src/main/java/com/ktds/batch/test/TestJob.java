package com.ktds.batch.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean{

	//반복적으로 수행될 파일
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("배치 동작 중...");
		
	}

}
