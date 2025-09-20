package finalAssignment;

public class PartTimeEmployee extends Employee {
	private double hourlyRate;
	private int mothlyWorkingHours;

	public PartTimeEmployee(String employeeId, String fullName, String dateOfBirth, String gend,
		String email, int phoneNumber, String hireDate, String jobTitle, String departmentId, String status,
		String lastPromotionDate, String password, int mothlyWorkingHours, double hourlyRate) {
		
		super(employeeId, fullName, dateOfBirth, gend, email, phoneNumber, hireDate,
			jobTitle, departmentId, status, lastPromotionDate, password);
		
		this.hourlyRate = hourlyRate;
		this.mothlyWorkingHours = mothlyWorkingHours;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getMothlyWorkingHours() {
		return mothlyWorkingHours;
	}

	public void setMothlyWorkingHours(int mothlyWorkingHours) {
		this.mothlyWorkingHours = mothlyWorkingHours;
	}
}
