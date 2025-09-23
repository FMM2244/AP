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
		setStatus(status);
		setType(type);
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
		else if (stat.compareTo("Rejected") == 0)
			status = Status.Rejected;
		else if (stat.compareTo("Pending") == 0)
			status = Status.Pending;
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

	public String getType() {
		if (type == Type.Maternity)
			return "Maternity";
		else if (type == Type.Paternity)
			return "Paternity";
		else if (type == Type.Sick)
			return "Sick";
		else if (type == Type.Unpaid)
			return "Unpaid";
		else if (type == Type.Vacation)
			return "Vacation";
		return "";
	}

	public void setType(String type) {
		if (type.compareTo("Maternity") == 0)
			this.type = Type.Maternity;
		else if (type.compareTo("Paternity") == 0)
			this.type = Type.Paternity;
		else if (type.compareTo("Sick") == 0)
			this.type = Type.Sick;
		else if (type.compareTo("Unpaid") == 0)
			this.type = Type.Unpaid;
		else if (type.compareTo("Vacation") == 0)
			this.type = Type.Vacation;
	}
}

