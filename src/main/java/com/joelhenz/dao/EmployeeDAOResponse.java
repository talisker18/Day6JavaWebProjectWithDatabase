package com.joelhenz.dao;

public class EmployeeDAOResponse {
	
	private boolean success;
	private String repsonseMsg; //if exception -> stacktrace
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getRepsonseMsg() {
		return repsonseMsg;
	}
	public void setRepsonseMsg(String repsonseMsg) {
		this.repsonseMsg = repsonseMsg;
	}
	
	

}
