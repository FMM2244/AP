package finalAssignment;

public class FullTimeEmployee extends Employee {

	private double salary;

	public FullTimeEmployee(String employeeId, String fullName, String dateOfBirth, String gend,
		String email, String phoneNumber, String hireDate, String jobTitle, String departmentId, String status,
		String lastPromotionDate, String password, double salary) {
		
		super(employeeId, fullName, dateOfBirth, gend, email, phoneNumber, hireDate,
			jobTitle, departmentId, status, lastPromotionDate, password);
		
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
