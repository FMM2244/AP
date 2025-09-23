package finalAssignment;

import java.util.ArrayList;
import java.util.Scanner;

public class HRResponsibilities implements IService {
	
	private Scanner scan;
	private Employee user;
	
	// reads employee data based on chosen option (1 full-time, 2 part-time, 3 contract)
    private String [] readData(String option) {

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

		if (option.compareTo("1") == 0) { // Full-time
			System.out.print("Salary: ");
            String salary = scan.nextLine();
			return new String[] {
				fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				salary
			};
		}
		else if (option.compareTo("2") == 0) { // Part-time
			System.out.print("Monthly Working Hours: ");
            String monthlyHours = scan.nextLine();
			System.out.print("Hourly Rate: ");
            String hourlyRate = scan.nextLine();
			return new String[] {
				fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				monthlyHours, hourlyRate
			};
		}
		else if (option.compareTo("3") == 0) { // Contract
			System.out.print("Contract Duration (months): ");
            String duration = scan.nextLine();
			System.out.print("Overall Payment: ");
            String overallPayment = scan.nextLine();
			return new String[] {
				fullName, dateOfBirth, gend, email, phoneNumber,
				hireDate, jobTitle, departmentId, status, lastPromotionDate, password,
				duration, overallPayment
			};
		}
		System.out.println("Invalid option selected");
		return null;
	}

	public void addEmployee(String employeeId) {

		Company company = Company.getInstance();
		if (company.getEmployees() == null) {
			java.util.HashMap<String, Employee> map = new java.util.HashMap<>();
			company.setEmployees(map);
		}
		else if (company.getEmployees().containsKey(employeeId)) {
			System.out.println("\nInvalid employee ID, employee already exists\n");
			return ;
		}

		System.out.println("choose employment type:\n  1. full time\n  2. part time\n  3. contract\nenter number: ");
		String option = scan.nextLine().trim();
		Employee newEmployee;


		String[] data = readData(option);
		if (data == null) {
			System.out.println("sorry!!! could not read employee data");
			return ;
		}

		try {
			if (option.compareTo("1") == 0) {
				newEmployee = new FullTimeEmployee(
					employeeId, data[0], data[3], data[4], data[5], data[6],
					data[7], data[8], data[9], data[10], data[11], data[10], Double.parseDouble(data[11])
				);
			}
			else if (option.compareTo("2") == 0) {
				newEmployee = new PartTimeEmployee(
					employeeId, data[0], data[3], data[4], data[5], data[6],
					data[7], data[8], data[9], data[10], data[11], data[10], Integer.parseInt(data[11]), Double.parseDouble(data[12])
				);
			}
			else if (option.compareTo("3") == 0) {
				newEmployee = new ContractEmployee(
					employeeId, data[0], data[3], data[4], data[5], data[6],
					data[7], data[8], data[9], data[10], data[11], data[10], Double.parseDouble(data[11]), Double.parseDouble(data[12])
				);
			}
			else {
				System.out.println("sorry invalid option");
				return ;
			}
		}
		catch (Exception e) {
			System.out.println("Invalid input values: " + e.getMessage());
			return ;
		}
		company.getEmployees().put(employeeId, newEmployee);
		System.out.println("\nEmployee Added successfully\n");
	}
	
	// separated logic for interactive updates on an employee
	public void updateData(Employee target) {

		Scanner input = new Scanner(System.in);

		System.out.println("Select field to update:\n"
			+ "1. Full Name\n"
			+ "2. Email\n"
			+ "3. Phone Number\n"
			+ "4. Job Title\n"
			+ "5. Department ID\n"
			+ "6. Password\n"
			+ "7. Last Promotion Date\n"
			+ "8. Hire Date");

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
                try {
                	target.setPhoneNumber(scan.nextLine().trim());
                }
				catch (Exception e) {
					System.out.println("Invalid phone number"); 
					input.close();
					return;
				}
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
						((FullTimeEmployee)target).setSalary(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid salary");
						input.close();
						return;
					}
				}
				else if (target instanceof PartTimeEmployee) {
					System.out.print("New Monthly Working Hours: ");
					try {
						((PartTimeEmployee)target).setMothlyWorkingHours(Integer.parseInt(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid hours");
						input.close();
						return;
					}
				}
				else if (target instanceof ContractEmployee) {
					System.out.print("New Contract Duration (months): ");
					try {
						((ContractEmployee)target).setDuration(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid duration");
						input.close();
						return;
					}
				}
				break;
			case 10:
				if (target instanceof PartTimeEmployee) {
					System.out.print("New Hourly Rate: ");
                    try {
                    	((PartTimeEmployee)target).setHourlyRate(Double.parseDouble(scan.nextLine().trim()));
                    }
					catch (Exception e) {
						System.out.println("Invalid rate");
						input.close();
						return;
					}
				}
				else if (target instanceof ContractEmployee) {
					System.out.print("New Overall Payment: ");
                    try {
						((ContractEmployee)target).setOverallPayment(Double.parseDouble(scan.nextLine().trim()));
					}
					catch (Exception e) {
						System.out.println("Invalid amount");
						input.close();
						return;
					}
				}
				else {
					System.out.println("Invalid option");
					input.close();
					return;
				}
				break;
			default:
				System.out.println("Invalid option");
				input.close();
				return;
		}
		input.close();
		System.out.println("Employee updated successfully.");
	}

	public void updateEmployeeInfo(String employeeId) {

		Company temp = Company.getInstance();
		if (temp.getEmployees() == null) {
			System.out.println("Invalid employee ID");
			return ;
		}
    	
		Employee target = temp.getEmployees().get(employeeId);
		if (target == null) {
			System.out.println("Invalid employee ID");
			return ;
		}

		System.out.print("Enter employee ID to update: ");
		String id = scan.nextLine();
		Company company = Company.getInstance();
		if (company.getEmployees() == null || !company.getEmployees().containsKey(id)) {
			System.out.println("Employee not found");
			return;
		}
		target = company.getEmployees().get(id);

		updateData(target);
	}

	public void processPayroll() {

		Company temp = Company.getInstance();
		ArrayList<Payroll> payroll = temp.getPayrolls();
		
		System.out.println("Please enter the following info");
		System.out.print("Payroll ID: ");
        String payrollId = scan.nextLine();
        
        for (int i = 0; i < payroll.size(); i++) {
        	if (payroll.get(i).getPayrollId().compareTo(payrollId) == 0) {
        		System.out.println("\nInvalid payroll ID, this ID already exists\n");
        		return ;
        	}
        }
		
        System.out.print("Employee ID: ");
        String employeeId = scan.nextLine();
        
        if (!temp.getEmployees().containsKey(employeeId)) {
        	System.out.println("\nInvalid employee ID, this ID does not exist\n");
    		return ;
        }
        
        System.out.print("Month: ");
        String month = scan.nextLine();

        double baseSalary;
        System.out.print("Base Salary: ");
        try {
        	baseSalary = Double.parseDouble(scan.nextLine().trim());        	
        }
        catch (Exception e) {
        	System.out.println("\nInvalid base salary input\n");
        	return ;
        }
        
        double bonuses;
        System.out.print("Bonuses amount: ");
        try {
        	bonuses = Double.parseDouble(scan.nextLine().trim());        	
        }
        catch (Exception e) {
        	System.out.println("\nInvalid Bonuses input\n");
        	return ;
        }
        
        double deductions;
        System.out.print("Deductions amount: ");
        try {
        	deductions = Double.parseDouble(scan.nextLine().trim());        	
        }
        catch (Exception e) {
        	System.out.println("\nInvalid Deductions input\n");
        	return ;
        }
        
        double taxWithheld;
        System.out.print("Tax Withheld amount: ");
        try {
        	taxWithheld = Double.parseDouble(scan.nextLine().trim());        	
        }
        catch (Exception e) {
        	System.out.println("\nInvalid Tax Withheld input\n");
        	return ;
        }
        
        System.out.print("Enter todays date: ");
        String processDate = scan.nextLine();
        
        temp.getPayrolls().add(new Payroll(payrollId, employeeId, month, baseSalary, bonuses, deductions, baseSalary - deductions + bonuses,taxWithheld, processDate));
	}

    public void promoteEmployee(String employeeId) {

    	Company temp = Company.getInstance();
		if (temp.getEmployees() == null) {
			System.out.println("Invalid employee ID");
			return ;
		}
    	
		Employee target = temp.getEmployees().get(employeeId);
		if (target == null) {
			System.out.println("Invalid employee ID");
			return ;
		}
		if (target.getStatus().compareTo("Termineted") == 0) {
			System.out.println("\nInvalid ID, Employee is Termineted\n");
			return ;
		}
		
		System.out.print("Enter todays date: ");
        String promotionDate = scan.nextLine();

        System.out.print("Enter new role (HR/Manager/Employee): ");
        String roleStr = scan.nextLine();

		// Update job title simply to match the role
		if (roleStr.equalsIgnoreCase("HR")) {
			target.setRole("HR");
			target.setLastPromotionDate(promotionDate);
			System.out.println("\nEmployee promoted successfully\n");
		}
		else if (roleStr.equalsIgnoreCase("Manager")) {
			target.setRole("Manager");
			target.setLastPromotionDate(promotionDate);
			System.out.println("\nEmployee promoted successfully\n");
		}
		else if (roleStr.equalsIgnoreCase("Manager")) {
			target.setJobTitle("Employee");
			target.setLastPromotionDate(promotionDate);
			System.out.println("\nEmployee promoted successfully\n");
		}
		else {
			System.out.println("\nInvalid role promotion\n");
		}
	}

	@Override
	public void printServicePrompt() {
		scan = new Scanner(System.in);
		String employeeId;
		
		while (true) {
			System.out.println("please enter 1, 2 or 3:");
			System.out.println("\t1. Add Employee");
			System.out.println("\t2. Update Employee Info");
			System.out.println("\t3. Promote Employee");
			System.out.println("\t4. Process Monthly Payroll");
			System.out.println("\t5. Exit");
			System.out.print("option: ");

			String option = scan.nextLine();
			
			if (option.compareTo("1") == 0) {
				System.out.print("please enter employee ID: ");
				employeeId = scan.nextLine();
				addEmployee(employeeId);
			}
			else if (option.compareTo("2") == 0) {
				System.out.print("please enter employee ID: ");
				employeeId = scan.nextLine();
				updateEmployeeInfo(employeeId);
			}
			else if (option.compareTo("3") == 0) {
				System.out.print("please enter employee ID: ");
				employeeId = scan.nextLine();
				promoteEmployee(employeeId);
			}
			else if (option.compareTo("4") == 0) {
				processPayroll();
			}
			else if (option.compareTo("5") == 0) {
				System.out.println("See you soon...");
				scan.close();
				break ;
			}
			else
				System.out.println("Invalid option, please select either 1, 2 or 3");
		}
	}
	
	public void setUser(Employee employee) {
		user = employee;
	}
}
