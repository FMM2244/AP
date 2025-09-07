/**
 * this is the company class that follows the Singleton design pattern
 * only one instance is allowed to exist from it in the entire system
 */

package com.finalassignment;
import java.util.ArrayList;
import java.util.HashMap;

public class Company implements IEmployeeAccess {
	
	protected HashMap<String, Employee> employees;
	protected HashMap<String, Department> departments;
	protected ArrayList<IReport> reports;
	protected ArrayList<LeaveRequest> leaveRequests;
	protected ArrayList<Payroll> payrolls;
	private IFileStrategy strategy;

	private static Company single = null;

	private Company() {

	}

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
	public void getResponsibility() {
		
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
		else if (strategy.compareTo("e-part-time") == 0) {
			this.strategy = new EmployeeContractFileStrategy(mode);
		}
		else if (strategy.compareTo("leaves") == 0) {
			this.strategy = new LeavesFileStrategy(mode);
		}
		else if (strategy.compareTo("payroll") == 0) {
			this.strategy = new PayrollFileStrategy(mode);
		}
	}
	
	public void readFormFile(String field) {
		
		String [] data;

		data = strategy.read();
		while (data != null) {
			data = strategy.read();
			if (field.compareTo("department") == 0)
				departments.put(data[0], new Department(data[0], data[1], data[2], Double.parseDouble(data[4]), data[3]));
			else if (field.compareTo("e-full-time") == 0)
				employees.put(data[0], new FullTimeEmployee(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6], data[7], data[9], data[10], data[11], data[12], Double.parseDouble(data[13])));
			else if (field.compareTo("e-part-time") == 0)
				employees.put(data[0], new PartTimeEmployee(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6], data[7], data[9], data[10], data[11], data[12], Integer.parseInt(data[13]), Double.parseDouble(data[14])));
			else if (field.compareTo("e-contract") == 0)
				employees.put(data[0], new ContractEmployee(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6], data[7], data[9], data[10], data[11], data[12], Double.parseDouble(data[13]), Double.parseDouble(data[14])));
			else if (field.compareTo("leaves") == 0)
				leaveRequests.add(new LeaveRequest(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
			else if (field.compareTo("payroll") == 0)
				payrolls.add(new Payroll(data[0], data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), data[8]));
		}
	}

	public void writeToFile(String field) {

		if (field.compareTo("department") == 0) {
			strategy.write("department_id	department_name	head_of_department_id	budget	location");
			for (Department d : departments.values()) {
				strategy.write(
					d.getId() + "\t" +
					d.getName() + "\t" +
					d.getHeadOfDepartmentId() + "\t" +
					d.getBudget() + "\t" +
					d.getLocation() + "\n");
			}
		}
		else if (field.compareTo("employee") == 0) {
			for (Employee e : employees.values()) {
				// if (e instanceof FullTimeEmployee)
				// strategy.write(
				// 	e.getId() + "\t" +
				// 	e.getName() + "\t" +
				// 	e.getHeadOfDepartmentId() + "\t" +
				// 	e.getBudget() + "\t" +
				// 	e.getLocation());
			}
		}
	}

	public void runTheCompany() {

		// read date from data set
		departments = new HashMap<>();
		setFileStrategy('r', "department");
		readFormFile("department");
		employees = new HashMap<String, Employee>();
		setFileStrategy('r', "e-full-time");
		readFormFile("e-full-time");
		setFileStrategy('r', "e-part-time");
		readFormFile("e-part-time");
		setFileStrategy('r', "e-contract");
		readFormFile("e-contract");
		leaveRequests = new ArrayList<>();
		setFileStrategy('r', "leaves");
		readFormFile("leaves");
		payrolls = new ArrayList<>();
		setFileStrategy('r', "payroll");
		readFormFile("payroll");

		// loging a certain user
		
		// show correct responsibility

		// call correct action based on request

		// writing all changes to files before exiting the program
	}

	// Generated getters and setters for instance fields
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
}
