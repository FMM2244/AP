/**
 * this is the company class that follows the Singleton design pattern
 * only one instance is allowed to exist from it in the entire system
 */

package com.finalassignment;
import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	protected HashMap<String, Employee> employees;
	protected HashMap<String, Department> departments;
	protected ArrayList<IReport> reports;
	protected ArrayList<LeaveRequests> leaveRequests;
	protected ArrayList<Payroll> payrolls;
	private static Company single = null;
	private IFileStrategy strategy;

	private Company() {

	}

	public static Company getInstance() {

		if (single == null)
			single = new Company();

		return single;
	}

	public void setFileStrategy() {
		 
	}

	public void readFormFile() {

	}

	public void writeToFile(String fileName) {

	}

	public void runTheCompany() {
		
	}
}
