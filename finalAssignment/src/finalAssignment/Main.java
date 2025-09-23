/**
 * this is the main class
 * everything starts here ...
 */

package finalAssignment;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
	
		Company company = Company.getInstance();
	
		// read date from data set
		company.departments = new HashMap<>();
		company.setFileStrategy('r', "department");
		company.readFormFile("department");
		company.employees = new HashMap<String, Employee>();
		company.setFileStrategy('r', "e-full-time");
		company.readFormFile("e-full-time");
		company.setFileStrategy('r', "e-part-time");
		company.readFormFile("e-part-time");
		company.setFileStrategy('r', "e-contract");
		company.readFormFile("e-contract");
		company.leaveRequests = new ArrayList<>();
		company.setFileStrategy('r', "leaves");
		company.readFormFile("leaves");
		company.payrolls = new ArrayList<>();
		company.setFileStrategy('r', "payroll");
		company.readFormFile("payroll");
	
		// running the company with services
		company.runTheCompany();
		
		company.setFileStrategy('w', "department");
		company.writeToFile("department");
		company.strategy.close();
		company.writeToFile("employee");
		company.strategy.close();
		company.setFileStrategy('w', "leaves");
		company.writeToFile("leaves");
		company.strategy.close();
		company.setFileStrategy('w', "payroll");
		company.writeToFile("payroll");
		company.strategy.close();
	}
}
