package finalAssignment;

public class LeaveRequest {

	private String leaveId;
	private String employeeId;
	private String approverId;
	private String startDate;
	private String endDate;
	private enum Type {
		Vacation, Unpaid, Maternity, Sick, Paternity
	}
	private Type type;
	private enum Status {
		Approved, Rejected, Pending
	}
	private Status status;

	public LeaveRequest(String leaveId, String employeeId, String type, String startDate, String endDate, String status, String approverId) {
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.approverId = approverId;
		this.startDate = startDate;
		this.endDate = endDate;

//		 status = Status.Pending;
	}
	
	public String getStatus() {
		if (status == Status.Pending)
			return "Pending";
		if (status == Status.Approved)
			return "Approved";
		if (status == Status.Rejected)
			return "Rejected";
		return "";
	}
	public void setStatus(String stat) {
		if (stat.compareTo("Approved") == 0)
			status = Status.Approved;
		if (stat.compareTo("Rejected") == 0)
			status = Status.Rejected;
	}

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}

