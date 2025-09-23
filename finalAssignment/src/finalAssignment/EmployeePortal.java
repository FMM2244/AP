package finalAssignment;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePortal implements IService {
	
	private Scanner scan;
	private Employee user;
	
	public EmployeePortal() {}
	
	public void createLeaveRequest(String id, String employeeId, String type, String startDate, String endDate) {
		Company temp = Company.getInstance();
		temp.getLeaveRequests().addLast(new LeaveRequest(id, employeeId, type, startDate, endDate, "Pending", "empty"));
	}
	
	public boolean displayPersonalInfo(Employee employee) {
		Company temp = Company.getInstance();
		if (!temp.getEmployees().containsKey(employee.getEmployeeId()))
				return false ;
		System.out.println("Employee Info:\n"
				+ "1. Full Name: " + employee.getFullName()
				+ "\n2. Email: " + employee.getEmail()
				+ "\n3. Phone Number: " + employee.getPhoneNumber()
				+ "\n4. Job Title: " + employee.getJobTitle()
				+ "\n5. Department ID: " + employee.getDepartmentId()
				+ "\n6. Password: " + employee.getPassword()
				+ "\n7. Last Promotion Date: " + employee.getLastPromotionDate()
				+ "\n8. Hire Date: " + employee.getHireDate());
		
		if (employee instanceof FullTimeEmployee) {
			System.out.println("9. Salary: " + ((FullTimeEmployee)employee).getSalary());
		}
		else if (employee instanceof PartTimeEmployee) {
			System.out.println("9. Monthly Working Hours: " + ((PartTimeEmployee)employee).getMothlyWorkingHours());
			System.out.println("10. Hourly Rate: " + ((PartTimeEmployee)employee).getHourlyRate());
		}
		else if (employee instanceof ContractEmployee) {
			System.out.println("9. Monthly Working Hours: " + ((ContractEmployee)employee).getDuration());
			System.out.println("10. Overall Payment: " + ((ContractEmployee)employee).getOverallPayment());
		}
		return true;
	}

	public void updatePersonalInfo(Employee employee) {
		
		System.out.println("Select field to update:\n"
				+ "1. Full Name\n"
				+ "2. Email\n"
				+ "3. Phone Number\n"
				+ "4. Password\n");

        System.out.print("Option: ");
        String option = scan.nextLine();

		if (option.compareTo("1") == 0) {
				System.out.print("New Full Name: ");
				employee.setFullName(scan.nextLine().trim());
		}
		else if (option.compareTo("2") == 0) {
				System.out.print("New Email: ");
				employee.setEmail(scan.nextLine());
		}
		else if (option.compareTo("3") == 0) {
				System.out.print("New Phone Number: ");
            	employee.setPhoneNumber(scan.nextLine().trim());
		}
		else if (option.compareTo("4") == 0) {
				System.out.print("New Password: ");
				employee.setPassword(scan.nextLine());
		}
		else {
			System.out.println("Invalid option");
				return;
		}
		System.out.println("\nEmployee updated successfully\n");
	}


	@Override
	public void printServicePrompt() {
		scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("please enter 1, 2 or 3:");
			System.out.println("\t1. View and update personal info");
			System.out.println("\t2. Request a leave");
			System.out.println("\t3. Exit");
			System.out.print("option: ");

			String option = scan.nextLine();
			
			if (option.compareTo("1") == 0) {
				displayPersonalInfo(user);
			}
			else if (option.compareTo("2") == 0) {
				updatePersonalInfo(user);
			}
			else if (option.compareTo("3") == 0) {
				Company temp = Company.getInstance();
				ArrayList<LeaveRequest> leaves = temp.getLeaveRequests();
				
				System.out.println("Please enter the following info:");

				System.out.println("Leave Type: ");
				String type = scan.nextLine();
				if (type.compareTo("Vacation") != 0 && type.compareTo("Unpaid") != 0 && type.compareTo("Maternity") != 0 && type.compareTo("Sick") != 0 && type.compareTo("Paternity") != 0) {
					System.out.println("Invalid leave request type");
					return ;
				}
				System.out.print("Leave ID: ");
				String id = scan.nextLine().trim();
				for (int i = 0; i < leaves.size(); i++) {
					if (leaves.get(i).getLeaveId().compareTo(id) == 0) {
						System.out.println("Invalid leave ID, this ID already exists");
						return ;
					}
				}
				System.out.print("Start Date: ");
				String startDate = scan.nextLine();
				System.out.print("End Date: ");
				String endDate = scan.nextLine();
				if (endDate.compareTo(startDate) < 0) {
					System.out.println("\nInvalid start and end dates\n");
					return ;
				}
				createLeaveRequest(id, user.getEmployeeId(), type, startDate, endDate);
			}
			else if (option.compareTo("4") == 0) {
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
