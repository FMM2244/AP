package com.finalassignment;

public class EmployeePortal implements IService {
	public LeaveRequest createLeaveRequest() {
		LeaveRequest newLeave = null;

		return newLeave;
	}

	public void updatePersonalInfo(Employee employee) {

	}

	@Override
	public void printServicePrompt(int option) {
		switch (option) {
			case 1:
				System.out.println("Employee: Create Leave Request");
				break;
			case 2:
				System.out.println("Employee: Update Personal Info");
				break;
			default:
				System.out.println("Employee: Invalid option");
		}
	}
}
