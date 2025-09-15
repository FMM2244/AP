/**
 * 
 */
package com.finalassignment;
import java.util.Scanner;

public class HRResponsibilities implements IService {
	
	private Scanner scan;

	public Employee addEmployee() {

		Employee newEmployee = null;
		java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("choose employment type:\n  1. full time\n  2. part time\n  3. contract\nenter number: ");
		int option;

		try {
			option = Integer.parseInt(sc.nextLine().trim());
		}
		catch (Exception e) {
			System.out.println("sorry invalid option");
			return null;
		}

		String[] data = readData(option);
		if (data == null) {
			System.out.println("could not read employee data");
			return null;
		}

		try {
			if (option == 1) {
				newEmployee = new FullTimeEmployee(
					data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
					data[6], data[7], data[8], data[9], data[10], data[11], Double.parseDouble(data[12])
				);
			} else if (option == 2) {
				newEmployee = new PartTimeEmployee(
					data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
					data[6], data[7], data[8], data[9], data[10], data[11], Integer.parseInt(data[12]), Double.parseDouble(data[13])
				);
			} else if (option == 3) {
				newEmployee = new ContractEmployee(
					data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
					data[6], data[7], data[8], data[9], data[10], data[11], Double.parseDouble(data[12]), Double.parseDouble(data[13])
				);
			} else {
				System.out.println("sorry invalid option");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Invalid input values: " + e.getMessage());
			return null;
		}

		Company company = Company.getInstance();
		if (company.getEmployees() == null) {
			java.util.HashMap<String, Employee> map = new java.util.HashMap<>();
			company.setEmployees(map);
		}
		company.getEmployees().put(data[0], newEmployee);
		return newEmployee;
	}

	public void updateEmployeeInfo(Employee employee) {
		Scanner input = new Scanner(System.in);
		Employee target = employee;
		if (target == null) {
			System.out.print("Enter employee ID to update: ");
			String id = input.nextLine();
			Company company = Company.getInstance();
			if (company.getEmployees() == null || !company.getEmployees().containsKey(id)) {
				System.out.println("Employee not found");
				return;
			}
			target = company.getEmployees().get(id);
		}

		updateData(target);
	}

	// separated logic for interactive updates on an employee
	public void updateData(Employee target) {
		Scanner input = new Scanner(System.in);
		System.out.println("Select field to update:\n"
			+ "1) Full Name\n"
			+ "2) Email\n"
			+ "3) Phone Number\n"
			+ "4) Job Title\n"
			+ "5) Department ID\n"
			+ "6) Password\n"
			+ "7) Last Promotion Date\n"
			+ "8) Hire Date");

		if (target instanceof FullTimeEmployee) {
			System.out.println("9) Salary");
		}
		else if (target instanceof PartTimeEmployee) {
			System.out.println("9) Monthly Working Hours\n10) Hourly Rate");
		}
		else if (target instanceof ContractEmployee) {
			System.out.println("9) Contract Duration (months)\n10) Overall Payment");
		}
        System.out.print("Option: ");
        String optStr = scan.nextLine();
		int opt = 0;
		try {
			opt = Integer.parseInt(optStr.trim());
		}
		catch (Exception ignored) {}

		switch (opt) {
			case 1:
				System.out.print("New Full Name: ");
                        target.setFullName(scan.nextLine());
				break;
			case 2:
				System.out.print("New Email: ");
                        target.setEmail(scan.nextLine());
				break;
			case 3:
				System.out.print("New Phone Number: ");
                        try { target.setPhoneNumber(Integer.parseInt(scan.nextLine().trim())); }
				catch (Exception e) { System.out.println("Invalid phone number"); return; }
				break;
			case 4:
				System.out.print("New Job Title: ");
                        target.setJobTitle(scan.nextLine());
				break;
			case 5:
				System.out.print("New Department ID: ");
                        target.setDepartmentId(scan.nextLine());
				break;
			case 6:
				System.out.print("New Password: ");
                        target.setPassword(scan.nextLine());
				break;
			case 7:
				System.out.print("New Last Promotion Date (YYYY-MM-DD): ");
                        target.setLastPromotionDate(scan.nextLine());
				break;
			case 8:
				System.out.print("New Hire Date (YYYY-MM-DD): ");
                        target.setHireDate(scan.nextLine());
				break;
			case 9:
				if (target instanceof FullTimeEmployee) {
					System.out.print("New Salary: ");
                    try {
						((FullTimeEmployee) target).setSalary(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid salary");
						return;
					}
				}
				else if (target instanceof PartTimeEmployee) {
					System.out.print("New Monthly Working Hours: ");
					try {
						((PartTimeEmployee) target).setMothlyWorkingHours(Integer.parseInt(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid hours");
						return;
					}
				}
				else if (target instanceof ContractEmployee) {
					System.out.print("New Contract Duration (months): ");
					try {
						((ContractEmployee) target).setDuration(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid duration");
						return;
					}
				}
				break;
			case 10:
				if (target instanceof PartTimeEmployee) {
					System.out.print("New Hourly Rate: ");
                            try { ((PartTimeEmployee) target).setHourlyRate(Double.parseDouble(scan.nextLine().trim())); }
					catch (Exception e) { System.out.println("Invalid rate"); return; }
				}
				else if (target instanceof ContractEmployee) {
					System.out.print("New Overall Payment: ");
                    try {
						((ContractEmployee) target).setOverallPayment(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid amount");
						return;
					}
				} else {
					System.out.println("Invalid option");
					return;
				}
				break;
			default:
				System.out.println("Invalid option");
				return;
		}

		System.out.println("Employee updated successfully.");
	}

	public void processPayroll(Payroll payroll) {

	}

    public void promoteEmployee(Employee employee) {
        if (scan == null) {
        if (scan == null) {
            scan = new Scanner(System.in);
        }
        }
        Employee target = employee;
        if (target == null) {
            System.out.print("Enter employee ID to promote: ");
            String id = scan.nextLine();
            Company company = Company.getInstance();
            if (company.getEmployees() == null || !company.getEmployees().containsKey(id)) {
                System.out.println("Employee not found");
                return;
            }
            target = company.getEmployees().get(id);
        }

        System.out.print("Enter new role (HR/Manager/Employee): ");
        String roleStr = scan.nextLine();

		// Update job title simply to match the role
		if (roleStr.equalsIgnoreCase("HR")) {
			target.setJobTitle("HR Specialist");
		}
		else if (roleStr.equalsIgnoreCase("Manager")) {
			target.setJobTitle("Manager");
		}
		else {
			target.setJobTitle("Employee");
		}

		// Update role via reflection (Role enum is private inside Employee)
		try {
			Class<?> roleEnum = null;
			for (Class<?> c : Employee.class.getDeclaredClasses()) {
				if (c.getSimpleName().equals("Role") && c.isEnum()) {
					roleEnum = c;
					break;
				}
			}
			if (roleEnum != null) {
				Object newRole = null;
				for (Object constant : roleEnum.getEnumConstants()) {
					if (((Enum<?>) constant).name().equalsIgnoreCase(roleStr)) {
						newRole = constant;
						break;
					}
				}
				if (newRole != null) {
					java.lang.reflect.Field f = Employee.class.getDeclaredField("role");
					f.setAccessible(true);
					f.set(target, newRole);
				}
			}
			System.out.println("Employee promoted successfully.");
		} catch (Exception e) {
			System.out.println("Could not update role: " + e.getMessage());
		}
	}

	// reads employee data based on chosen option (1 full-time, 2 part-time, 3 contract)
    public String [] readData(int option) {
        if (scan == null) {
            scan = new Scanner(System.in);
        }

		System.out.print("Employee ID: ");
        String employeeId = scan.nextLine();
		System.out.print("Full Name: ");
        String fullName = scan.nextLine();
		System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scan.nextLine();
		System.out.print("Gender (Male/Female): ");
        String gend = scan.nextLine();
		System.out.print("Email: ");
        String email = scan.nextLine();
		System.out.print("Phone Number (digits only): ");
        String phoneNumber = scan.nextLine();
		System.out.print("Hire Date (YYYY-MM-DD): ");
        String hireDate = scan.nextLine();
		System.out.print("Job Title: ");
        String jobTitle = scan.nextLine();
		System.out.print("Department ID: ");
        String departmentId = scan.nextLine();
		System.out.print("Status (Active/Termineted): ");
        String status = scan.nextLine();
		System.out.print("Last Promotion Date (YYYY-MM-DD): ");
        String lastPromotionDate = scan.nextLine();
		System.out.print("Password: ");
        String password = scan.nextLine();

		if (option == 1) { // Full-time
			System.out.print("Salary: ");
            String salary = scan.nextLine();
			return new String[] {
				employeeId, fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				salary
			};
		} else if (option == 2) { // Part-time
			System.out.print("Monthly Working Hours: ");
            String monthlyHours = scan.nextLine();
			System.out.print("Hourly Rate: ");
            String hourlyRate = scan.nextLine();
			return new String[] {
				employeeId, fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				monthlyHours, hourlyRate
			};
		} else if (option == 3) { // Contract
			System.out.print("Contract Duration (months): ");
            String duration = scan.nextLine();
			System.out.print("Overall Payment: ");
            String overallPayment = scan.nextLine();
			return new String[] {
				employeeId, fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				duration, overallPayment
			};
		}

		System.out.println("Invalid option selected");
		return null;
	}

	@Override
	public void printServicePrompt(int option) {
		scan = new Scanner(System.in);
		switch (option) {
			case 1:
				System.out.println("HR: Add Employee");
				break;
			case 2:
				System.out.println("HR: Update Employee Info");
				break;
			default:
				System.out.println("HR: Invalid option");
		}
		// do not close shared Scanner tied to System.in
	}
}
