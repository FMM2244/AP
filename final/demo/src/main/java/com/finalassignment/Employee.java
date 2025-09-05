package com.finalassignment;

public abstract class Employee {
	private String employeeId;
	private String fullName;
	private Date dateOfBirth;
	private String email;
	private int phoneNumber;
	private Date hireDate;
	private String departmentId;
	private Date lastPromotionDate;
	private String jobTitle;
	private String password;
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
		Active, termineted
	}
	private Status Status;
	
	public Employee(String employeeId, String fullName, int dayOfBirth, int monthOfBirth, int yearOfBirth,
		String email, int phoneNumber, Date hireDate, String departmentId, String status,
		int dayLastPromotion, int monthLastPromotion, int yearLastPromotion,
		String jobTitle, String password, String gend) {

		this.dateOfBirth = new Date(dayOfBirth, monthOfBirth, yearOfBirth);
		this.lastPromotionDate = new Date(dayLastPromotion, monthLastPromotion, yearLastPromotion);
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.departmentId = departmentId;
		this.jobTitle = jobTitle;
		if (jobTitle.contains("HR"))
			role = Role.HR;
		else if (jobTitle.contains("Manager"))
			role = Role.Manager;
		else 
			role = Role.Employee;
		
		if (gend.compare("Male") || gend.compare("Male"))
			// gender = gender.Male;
		else
			// gender = gender.Female;

		if (jobTitle.contains("HR"))
			// gender = gender.Male;
		else
			// gender = gender.Female;
	}
}