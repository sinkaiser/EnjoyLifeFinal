package com.log.model;

public class AdminLogBean implements java.io.Serializable {
	private Integer logNo;
	private java.util.Date logDate;
	private String executor;
	private String executorIp;
	private String executeTarget;
	private String executeAction;
	private String targetDescription;
	
	public Integer getLogNo() {
		return logNo;
	}
	public void setLogNo(Integer logNo) {
		this.logNo = logNo;
	}
	public java.util.Date getLogDate() {
		return logDate;
	}
	public void setLogDate(java.util.Date logDate) {
		this.logDate = logDate;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public String getExecutorIp() {
		return executorIp;
	}
	public void setExecutorIp(String executorIp) {
		this.executorIp = executorIp;
	}
	public String getExecuteTarget() {
		return executeTarget;
	}
	public void setExecuteTarget(String executeTarget) {
		this.executeTarget = executeTarget;
	}
	public String getExecuteAction() {
		return executeAction;
	}
	public void setExecuteAction(String executeAction) {
		this.executeAction = executeAction;
	}
	public String getTargetDescription() {
		return targetDescription;
	}
	public void setTargetDescription(String targetDescription) {
		this.targetDescription = targetDescription;
	}
}
