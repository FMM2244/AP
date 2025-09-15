package com.finalassignment;

public abstract class Employee {

	private String employeeId;
	private String fullName;
	private String dateOfBirth;
	private String email;
	private String hireDate;
	private String departmentId;
	private String lastPromotionDate;
	private String jobTitle;
	private String password;
	private int phoneNumber;

	private enum Role {
		HR,
		Manager,
		Employee
	}
	private Role role;

	private enum Gender {
		Female, Male
	}
	private Gender gender;

	private enum Status {
		Active, Termineted
	}
	private Status status;
	
	public Employee(String employeeId, String fullName, String dateOfBirth, String gend,
		String email, int phoneNumber, String hireDate, String jobTitle, String departmentId, String status,
		String lastPromotionDate, String password) {

		this.dateOfBirth = dateOfBirth;
		this.hireDate = hireDate;
		this.lastPromotionDate = lastPromotionDate;
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		
		// check if the jobTitle has HR or Manager in it to determine the correct role
		if (jobTitle.contains("HR"))
			role = Role.HR;
		else if (jobTitle.contains("Manager"))
			role = Role.Manager;
		else 
			role = Role.Employee;
		
		// to determine the correct gender 
		if (gend.compareTo("Male") == 0 || gend.compareTo("male") == 0)
			gender = Gender.Male;
		else if (gend.compareTo("Female") == 0 || gend.compareTo("female") == 0)
			gender = Gender.Female;

		// to determine the correct status
		if (status.compareTo("Active") == 0)
			this.status = Status.Active;
		else if (gend.compareTo("Termineted") == 0)
			this.status = Status.Termineted;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getPassword() {
		return password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getLastPromotionDate() {
		return lastPromotionDate;
	}

	public void setLastPromotionDate(String lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		if (role == Role.HR)
			return "HR";
		if (role == Role.Manager)
			return "Manager";
		return "Employee";
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		if (gender == Gender.Female)
			return "Female";
		return "Male";
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
