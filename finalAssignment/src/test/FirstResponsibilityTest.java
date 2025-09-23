package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import finalAssignment.Company;
import finalAssignment.Employee;
import finalAssignment.EmployeePortal;
import finalAssignment.LeaveRequest;

class FirstResponsibilityTest {
	
	private Company company;
	private Employee emp;

	@BeforeAll
	void setUpBeforeClass() {
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
		
		company.service = new EmployeePortal();
	}
	
	@Test
    void TC001_requestValidLeave() {
        emp = company.employees.get("E001");
        ((EmployeePortal)company.service).createLeaveRequest("LVE001", "E001", "vacation", "2025-09-20", "2025-09-25");
        boolean result = false;
        LeaveRequest temp = null;
        for (LeaveRequest l : company.leaveRequests) {
        	if (l.getLeaveId().compareTo("LVE001") == 0) {
        		result = true;
        		temp = l;
        	}
        }
        assertTrue(result, "Leave request is logged");
        assertEquals("pending", temp.getStatus());
    }

    @Test
    void TC002_requestInvalidLeave() {
    	emp = company.employees.get("E001");
        ((EmployeePortal)company.service).createLeaveRequest("LVE001", "E001", "vacation", "2025-09-20", "2025-09-25");
        boolean result = false;
        LeaveRequest temp = null;
        for (LeaveRequest l : company.leaveRequests) {
        	if (l.getLeaveId().compareTo("LVE001") == 0) {
        		result = true;
        		temp = l;
        	}
        }
        assertFalse(result, "correct reuslt");
        assertNotNull(temp);
    }
    
    @AfterAll
    void cleanUp() {
    	System.out.println("finished first test cases");
    }

}
