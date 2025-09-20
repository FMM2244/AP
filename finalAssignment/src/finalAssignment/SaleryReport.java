package finalAssignment;

public class SaleryReport implements IReport {

	private int reportId;
	private String content;
	private String date;

	public SaleryReport() {

	}

	@Override
	public IReport generateReport() {
		return this;
	}

	@Override
	public void Display() {
		
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
