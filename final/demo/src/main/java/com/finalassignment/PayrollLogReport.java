/**
 * TaxSummaryReport this class handles tax summary reports which will be
 * genetared by the Manager
 */
package com.finalassignment;

public class PayrollLogReport implements IReport {

	private int reportId;
	private String content;
	private Date date;

	public PayrollLogReport() {

	}

	@Override
	public IReport generateReport() {
		return this;
	}

	@Override
	public void Display() {
		
	}

	// Generated getters and setters
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
