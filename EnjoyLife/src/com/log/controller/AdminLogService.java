package com.log.controller;

import com.log.model.AdminLogBean;

public class AdminLogService {
	
	AdminLogBean bean=new AdminLogBean();
	AdminLogDao dao=new AdminLogDaoHibernate();
	
	public Integer add(String executeTarget,String executor,String executorIp,String targetDescription,String executeAction){
		Integer result=0;
		
		bean.setExecuteAction(executeAction);
		bean.setExecuteTarget(executeTarget);
		bean.setExecutor(executor);
		bean.setExecutorIp(executorIp);
		bean.setLogDate(new java.util.Date());
		bean.setTargetDescription(targetDescription);
		result=dao.insert(bean);
		
		return result;
	}
	public Integer delete(){
		Integer result=0;
		
		
		result=dao.deleteByTime(); //成功比數
		
		return result;
	}
	
	
	
}
