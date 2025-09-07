package com.finalassignment;

public class Payroll {

	private String payrollId;
	private String employeeId;
	private String month;
	private String processedDate;
	private double baseSalary;
	private double bonuses;
	private double deductions;
	private double taxWithheld;
	private double netSalary;

	public Payroll(String payrollId, String employeeId, String month, double baseSalary,
		double bonuses, double deductions, double netSalary, double taxWithheld, String processedDate) {
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.month = month;
		this.baseSalary = baseSalary;
		this.bonuses = bonuses;
		this.deductions = deductions;
		this.taxWithheld = taxWithheld;
		this.netSalary = netSalary;
		this.processedDate = processedDate;
	}

	// Generated getters and setters
	public String getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(String payrollId) {
		this.payrollId = payrollId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(String processedDate) {
		this.processedDate = processedDate;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getBonuses() {
		return bonuses;
	}

	public void setBonuses(double bonuses) {
		this.bonuses = bonuses;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getTaxWithheld() {
		return taxWithheld;
	}

	public void setTaxWithheld(double taxWithheld) {
		this.taxWithheld = taxWithheld;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
}
