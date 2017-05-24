package com.ktds.batch.account.dormant;

import java.util.function.Consumer;
import java.util.stream.Stream;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ktds.batch.BatchContext;
import com.ktds.batch.account.dormant.biz.DormantAccountBiz;
import com.ktds.batch.account.dormant.vo.UsersVO;

public class DormantAccountJob extends QuartzJobBean {

	private DormantAccountBiz dormantAccountBiz;

//	public DormantAccountJob(){
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("rootContext.xml","jobScheduler.xml");
//		dormantAccountBiz = ctx.getBean("dormantAccountBizImpl",DormantAccountBiz.class);
//	}
//	
//	public void setDormantAccountBiz(DormantAccountBiz dormantAccountBiz) {
//		this.dormantAccountBiz = dormantAccountBiz;
//	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		dormantAccountBiz=
				BatchContext.getBean("dormantAccountBizImpl");
		
		//stream으로 반복 돌리기
		Stream<UsersVO> usersVO = dormantAccountBiz.getAllDormantAccounts();
		
		usersVO.forEach(new Consumer<UsersVO>() {
			
			@Override
			public void accept(UsersVO t) {
				//휴면계정이면 어떤처리를 해주자
				System.out.println(t.getUserId());
			}
		});
	}

}
