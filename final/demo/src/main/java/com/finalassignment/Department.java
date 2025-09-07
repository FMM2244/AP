package com.finalassignment;

public class Department {
	private String id;
	private String name;
	private String headOfDepartmentId;
	private String location;
	private double budget;

	public Department(String id, String name, String headOfDepartmentId, double budget, String location) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.location = location;
		this.headOfDepartmentId = headOfDepartmentId;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getHeadOfDepartmentId() {
		return headOfDepartmentId;
	}
	
	public String getLocation() {
		return location;
	}

	public double getBudget() {
		return budget;
	}

	// Generated setters
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeadOfDepartmentId(String headOfDepartmentId) {
		this.headOfDepartmentId = headOfDepartmentId;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
}
