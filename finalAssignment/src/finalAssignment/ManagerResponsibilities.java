/**
 * 
 * This class contains the services that managers can access
 * 
 * it displays a prompt to the manager indicating the options available to the manager
 * 
 */
package finalAssignment;

import java.util.*;

public class ManagerResponsibilities implements IService {

	private Scanner scan;
	private Employee user;

	public ManagerResponsibilities() {}

	public void generateReports(String reportType) {
		IReport report;

		if (reportType == null)
			return;

		if (reportType.equalsIgnoreCase("tax")) {
			report = new TaxSummaryReport();
		}
		else if (reportType.equalsIgnoreCase("payroll")) {
			report = new PayrollLogReport();
		}
		else if (reportType.equalsIgnoreCase("salary")) {
			report = new SaleryReport();
		}
		else {
			System.out.println("Unknown report type");
			return;
		}

		Company temp = Company.getInstance();
		temp.getReports().add(report);
	}

	public void approveLeave(String id) {
		Company temp = Company.getInstance();

		ArrayList<LeaveRequest> leaves = temp.getLeaveRequests();
		for (int i = 0; i < leaves.size(); i++) {
			if (leaves.get(i).getLeaveId().compareTo(id) == 0) {
				leaves.get(i).setStatus("approved");
				leaves.get(i).setApproverId(user.getEmployeeId());
				System.out.println("\nLeave request approved successfully\n");
				return ;
			}
		}
		System.out.println("Invalid leave ID");
	}

	public void rejectLeave(String id) {
		Company temp = Company.getInstance();

		ArrayList<LeaveRequest> leaves = temp.getLeaveRequests();
		for (int i = 0; i < leaves.size(); i++) {
			if (leaves.get(i).getLeaveId().compareTo(id) == 0) {
				leaves.get(i).setStatus("rejected");
				leaves.get(i).setApproverId(user.getEmployeeId());
				System.out.println("\nLeave request rejected successfully\n");
				return ;
			}
		}
		System.out.println("Invalid leave ID");
	}

	public void delayLeave(String id) {
		Company temp = Company.getInstance();

		ArrayList<LeaveRequest> leaves = temp.getLeaveRequests();
		for (int i = 0; i < leaves.size(); i++) {
			if (leaves.get(i).getLeaveId().compareTo(id) == 0) {
				leaves.get(i).setStatus("delayed");
				leaves.get(i).setApproverId(user.getEmployeeId());
				System.out.println("\nLeave request delayed successfully\n");
				return ;
			}
		}
		System.out.println("Invalid leave ID");
	}

	@Override
	public void printServicePrompt() {
		scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("please enter 1, 2 or 3:");
			System.out.println("\t1. Generate Report");
			System.out.println("\t2. Process leave");
			System.out.println("\t3. Exit");
			System.out.print("option: ");

			String option = scan.nextLine();
			
			if (option.compareTo("1") == 0) {
				System.out.print("Please input report type: ");
				String type = scan.nextLine();
				generateReports(type);
			}
			else if (option.compareTo("2") == 0) {
				System.out.print("Please enter leave ID: ");
				String id = scan.nextLine();
				System.out.print("Please choose weather to delay, approve or reject leave");
				String status = scan.nextLine();
				if (status.compareTo("delay") != 0 && status.compareTo("approve") != 0 && status.compareTo("reject") != 0) {
					System.out.println("Invalid leave status");
					continue ;
				}
				else if (status.compareTo("delay") == 0)
					delayLeave(id);
				else if (status.compareTo("approve") == 0)
					approveLeave(id);
				else if (status.compareTo("reject") == 0)
					rejectLeave(id);
			}
			else if (option.compareTo("3") == 0) {
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

