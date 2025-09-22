package finalAssignment;

public class ContractEmployee extends Employee {
	private double duration;
	private double overallPayment;

	public ContractEmployee(String employeeId, String fullName, String dateOfBirth, String gend,
		String email, String phoneNumber, String hireDate, String jobTitle, String departmentId, String status,
		String lastPromotionDate, String password, double duration, double overallPayment) {
		
		super(employeeId, fullName, dateOfBirth, gend, email, phoneNumber, hireDate,
			jobTitle, departmentId, status, lastPromotionDate, password);
		
		this.duration = duration;
		this.overallPayment = overallPayment;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getOverallPayment() {
		return overallPayment;
	}

	public void setOverallPayment(double overallPayment) {
		this.overallPayment = overallPayment;
	}
}