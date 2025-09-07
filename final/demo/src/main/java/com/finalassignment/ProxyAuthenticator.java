package com.finalassignment;

public class ProxyAuthenticator implements IEmployeeAccess {

	private Employee requester;

	public ProxyAuthenticator(Employee requester) {
		this.requester = requester;
	}

	@Override
	public boolean authenticate(String employeeId, String password) {
		if (requester.getPassword().compareTo(password) == 0)
			return true;
		return false;
	}

	@Override
	public void getResponsibility() {

	}

	// Generated getters and setters
	public Employee getRequester() {
		return requester;
	}

	public void setRequester(Employee requester) {
		this.requester = requester;
	}
}
