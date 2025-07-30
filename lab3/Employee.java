
package lab3;

public class Employee {
	private String name;
	private Department dept;
	private Address add;
	private Date birthdate;

	public Employee(String name, String street, String city, int bldNum, int day, int month, int year, Department dept) {
		add = new Address(bldNum, street, city);
		birthdate = new Date(day, month, year);
		this.dept = dept;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return add.getAddress();
	}

	public String getBDate() {
		return birthdate.getDate();
	}

	public Department getDept() {
		return dept;
	}
}
