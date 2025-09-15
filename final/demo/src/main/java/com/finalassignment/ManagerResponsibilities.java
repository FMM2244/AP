/**
 * 
 */
package com.finalassignment;
import java.util.Scanner;

public class ManagerResponsibilities implements IService {

	IReport report;
	private Scanner scan;

	public ManagerResponsibilities() {

	}

	public void generateReports(String reortType) {
		if (reortType == null) return;
		if (reortType.equalsIgnoreCase("tax")) {
			report = new TaxSummaryReport();
		} else if (reortType.equalsIgnoreCase("payroll")) {
			report = new PayrollLogReport();
		} else if (reortType.equalsIgnoreCase("salary")) {
			report = new SaleryReport();
		} else {
			System.out.println("Unknown report type");
			return;
		}
		report.generateReport();
	}

	public void approveLeave(LeaveRequest leave) {

	}

	public void rejectLeave(LeaveRequest leave) {
		
	}

	public void delayLeave(LeaveRequest leave) {
		
	}

	@Override
	public void printServicePrompt(int option) {
		switch (option) {
			case 1:
				System.out.println("Manager: Generate Report");
				break;
			case 2:
				System.out.println("Manager: Approve Leave");
				break;
			default:
				System.out.println("Manager: Invalid option");
		}
	}

	// Generated getters and setters
	public IReport getReport() {
		return report;
	}

	public void setReport(IReport report) {
		this.report = report;
	}
}
