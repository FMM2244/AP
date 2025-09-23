package finalAssignment;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Company implements IEmployeeAccess {
	
	public HashMap<String, Employee> employees;
	public HashMap<String, Department> departments;
	public ArrayList<IReport> reports;
	public ArrayList<LeaveRequest> leaveRequests;
	public ArrayList<Payroll> payrolls;
	public IFileStrategy strategy;
	public IService service;

	private static Company single = null;

	private Company() {}

	public static Company getInstance() {

		if (single == null)
			single = new Company();

		return single;
	}
	
	@Override
	public boolean authenticate(String employeeId, String password) {
		return false;
	}
	
	@Override
	public void getResponsibility() {}

	public void runTheCompany() {
		Scanner scan = new Scanner(System.in);
		ProxyAuthenticator proxy = new ProxyAuthenticator();
		
		System.out.println("=== Welcome to Company Portal ===");
		
		boolean loggedIn = false;
		while (!loggedIn) {
			System.out.print("Enter Employee ID: ");
			String employeeId = scan.nextLine().trim();

			System.out.print("Enter Password: ");
			String password = scan.nextLine().trim();
			
			// System.out.println("debugging print statement: " + employeeId + ", " + password);

			loggedIn = proxy.authenticate(employeeId, password);

			if (!loggedIn) {
				System.out.println("Invalid credentials. Try again.\n");
			}
		}

		// After successful login, redirect to the correct service
		proxy.getResponsibility();

		// Optional: call specific service prompts
		Employee currentUser = proxy.getRequester();
		IService service = null;

		switch (currentUser.getRole()) {
			case "HR":
				service = new HRResponsibilities();
				service.setUser(currentUser);
				break;
			case "Manager":
				service = new ManagerResponsibilities();
				service.setUser(currentUser);
				break;
			case "Employee":
				service = new EmployeePortal();
				service.setUser(currentUser);
				break;
		}

		if (service != null) {
			System.out.println("\nSelect an option:");
			service.printServicePrompt();
		}
		scan.close();
	}

	public void setFileStrategy(char mode, String strategy) {
		if (strategy.compareTo("department") == 0) {
			this.strategy = new DepartmentFileStrategy(mode);	
		}
		else if (strategy.compareTo("e-full-time") == 0) {
			this.strategy = new EmployeeFullTimeFileStrategy(mode);
		}
		else if (strategy.compareTo("e-part-time") == 0) {
			this.strategy = new EmployeePartTimeFileStrategy(mode);
		}
		else if (strategy.compareTo("e-contract") == 0) {
			this.strategy = new EmployeeContractFileStrategy(mode);
		}
		else if (strategy.compareTo("leaves") == 0) {
			this.strategy = new LeavesFileStrategy(mode);
		}
		else if (strategy.compareTo("payroll") == 0) {
			this.strategy = new PayrollFileStrategy(mode);
		}
	}
	
	public void setFileStrategy(char mode, String strategy, boolean append) {
		if (strategy.compareTo("department") == 0) {
			this.strategy = new DepartmentFileStrategy(mode, append);	
		}
		else if (strategy.compareTo("e-full-time") == 0) {
			this.strategy = new EmployeeFullTimeFileStrategy(mode, append);
		}
		else if (strategy.compareTo("e-part-time") == 0) {
			this.strategy = new EmployeePartTimeFileStrategy(mode, append);
		}
		else if (strategy.compareTo("e-contract") == 0) {
			this.strategy = new EmployeeContractFileStrategy(mode, append);
		}
		else if (strategy.compareTo("leaves") == 0) {
			this.strategy = new LeavesFileStrategy(mode, append);
		}
		else if (strategy.compareTo("payroll") == 0) {
			this.strategy = new PayrollFileStrategy(mode, append);
		}
	}
	
	public void readFormFile(String field) {
		
		String [] data;

		data = strategy.read();
		while (data != null && data[0] != null) {
			if (field.compareTo("department") == 0)
				departments.put(data[0], new Department(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4]));
			else if (field.compareTo("e-full-time") == 0)
				employees.put(data[0], new FullTimeEmployee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[9], data[10], data[11], data[12], Double.parseDouble(data[13])));
			else if (field.compareTo("e-part-time") == 0)
				employees.put(data[0], new PartTimeEmployee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[9], data[10], data[11], data[12], Integer.parseInt(data[13]), Double.parseDouble(data[14])));
			else if (field.compareTo("e-contract") == 0)
				employees.put(data[0], new ContractEmployee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[9], data[10], data[11], data[12], Double.parseDouble(data[13]), Double.parseDouble(data[14])));
			else if (field.compareTo("leaves") == 0)
				leaveRequests.add(new LeaveRequest(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
			else if (field.compareTo("payroll") == 0)
				payrolls.add(new Payroll(data[0], data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), data[8]));
			data = strategy.read();
		}
	}

	public void writeToFile(String field) {

		if (field.compareTo("department") == 0) {
			strategy.write("department_id\tdepartment_name\thead_of_department_id\tbudget\tlocation");
			for (Department temp : departments.values()) {
				strategy.write(temp.getId() + "\t"
						+ temp.getName() + "\t"
						+ temp.getHeadOfDepartmentId() + "\t"
						+ Double.toString(temp.getBudget()) + "\t"
						+ temp.getLocation());
			}
		}
		else if (field.compareTo("employee") == 0) {
			setFileStrategy('w', "e-full-time");
			strategy.write("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\temployment_type\tdepartment_id\tstatus\tlast_promotion_date\tPassword\tsalary_base");
			strategy.close();
			setFileStrategy('w', "e-part-time");
			strategy.write("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\temployment_type\tdepartment_id\tstatus\tlast_promotion_date\tPassword\tworking_hours_per_month\trate_per_hour");
			strategy.close();
			setFileStrategy('w', "e-contract");
			strategy.write("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\tEmployee_type\tdepartment_id\tstatus\tlast_promotion_date\tpassword\tduration\toverall_payment");
			strategy.close();
			for (Employee temp : employees.values()) {
				if (temp instanceof FullTimeEmployee) {
					setFileStrategy('w', "e-full-time", true);
					strategy.write(temp.getEmployeeId() + "\t"
							+ temp.getFullName() + "\t"
							+ temp.getDateOfBirth() + "\t"
							+ temp.getGender() + "\t"
							+ temp.getEmail() + "\t"
							+ temp.getPhoneNumber() + "\t"
							+ temp.getHireDate() + "\t"
							+ temp.getJobTitle() + "\t"
							+ "Full-time\t"
							+ temp.getDepartmentId() + "\t"
							+ temp.getStatus() + "\t"
							+ temp.getLastPromotionDate() + "\t"
							+ temp.getPassword() + "\t"
							+ ((FullTimeEmployee)temp).getSalary());
					strategy.close();
				}
				else if (temp instanceof PartTimeEmployee) {
					setFileStrategy('w', "e-part-time", true);
					strategy.write(temp.getEmployeeId() + "\t"
							+ temp.getFullName() + "\t"
							+ temp.getDateOfBirth() + "\t"
							+ temp.getGender() + "\t"
							+ temp.getEmail() + "\t"
							+ temp.getPhoneNumber() + "\t"
							+ temp.getHireDate() + "\t"
							+ temp.getJobTitle() + "\t"
							+ "Part-time\t"
							+ temp.getDepartmentId() + "\t"
							+ temp.getStatus() + "\t"
							+ temp.getLastPromotionDate() + "\t"
							+ temp.getPassword() + "\t"
							+ ((PartTimeEmployee)temp).getMothlyWorkingHours() + "\t"
							+ ((PartTimeEmployee)temp).getHourlyRate());
					strategy.close();
				}
				else if (temp instanceof ContractEmployee) {
					setFileStrategy('w', "e-contract", true);
					strategy.write(temp.getEmployeeId() + "\t"
							+ temp.getFullName() + "\t"
							+ temp.getDateOfBirth() + "\t"
							+ temp.getGender() + "\t"
							+ temp.getEmail() + "\t"
							+ temp.getPhoneNumber() + "\t"
							+ temp.getHireDate() + "\t"
							+ temp.getJobTitle() + "\t"
							+ "Contractor\t"
							+ temp.getDepartmentId() + "\t"
							+ temp.getStatus() + "\t"
							+ temp.getPassword() + "\t"
							+ temp.getLastPromotionDate() + "\t"
							+ ((ContractEmployee)temp).getDuration() + "\t"
							+ ((ContractEmployee)temp).getOverallPayment());
					strategy.close();
				}
			}
		}
		else if (field.compareTo("leaves") == 0) {
			strategy.write("leave_id\temployee_id\tleave_type\tstart_date\tend_date\tapproval_status\tapprover_id");
			for (LeaveRequest temp : leaveRequests) {
				strategy.write(temp.getLeaveId() + "\t"
						+ temp.getEmployeeId() + "\t"
						+ temp.getType() + "\t"
						+ temp.getStartDate() + "\t"
						+ temp.getEndDate() + "\t"
						+ temp.getStatus() + "\t"
						+ temp.getApproverId());
			}
		}
		else if (field.compareTo("payroll") == 0) {
			strategy.write("payroll_id\temployee_id\tmonth\tbase_salary\tbonuses\tdeductions\tnet_salary\ttax_withheld\tprocessed_date");
			for (Payroll temp : payrolls) {
				strategy.write(temp.getPayrollId() + "\t"
						+ temp.getEmployeeId() + "\t"
						+ temp.getMonth() + "\t"
						+ temp.getBaseSalary() + "\t"
						+ temp.getBonuses() + "\t"
						+ temp.getDeductions() + "\t"
						+ temp.getNetSalary() + "\t"
						+ temp.getTaxWithheld() + "\t"
						+ temp.getProcessedDate());
			}
		}
	}

	public HashMap<String, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(HashMap<String, Employee> employees) {
		this.employees = employees;
	}

	public HashMap<String, Department> getDepartments() {
		return departments;
	}

	public void setDepartments(HashMap<String, Department> departments) {
		this.departments = departments;
	}

	public ArrayList<IReport> getReports() {
		return reports;
	}

	public void setReports(ArrayList<IReport> reports) {
		this.reports = reports;
	}

	public ArrayList<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(ArrayList<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	public ArrayList<Payroll> getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(ArrayList<Payroll> payrolls) {
		this.payrolls = payrolls;
	}

	public IFileStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IFileStrategy strategy) {
		this.strategy = strategy;
	}

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}
}
