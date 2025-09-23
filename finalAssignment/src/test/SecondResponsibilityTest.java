package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import finalAssignment.Company;
import finalAssignment.Employee;
import finalAssignment.EmployeePortal;
import finalAssignment.HRResponsibilities;

class SecondResponsibilityTest {
	
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
		
		company.service = new HRResponsibilities();
	}

	@Test
    void TC003_viewPersonalData() {
		emp = company.employees.get("E007");
        boolean result = ((EmployeePortal)company.service).displayPersonalInfo(emp);
        assertTrue(result, "Info has been displayed");
        assertNotNull(emp, "User exists");
    }

    @Test
    void TC004_updatePersonalData() {
    	emp = company.employees.get("E007");
    	// this segment of code will simulate the standard input of the user
        String simulatedInput = "3\n"
                              + "0791294848\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // this segment of code will simulate the standard output of the user
        // this will help assess weather the system prompts the correct statements 
        // when neccesary
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
        	((HRResponsibilities)company.service).updateEmployeeInfo("E200");;

            // converts output to string
            String output = outContent.toString();
            assertTrue(output.contains("Employee updated successfully"));
        }
        finally {
            // back to original input and output streams
            System.setIn(System.in);
            System.setOut(originalOut);
        }
    }
    
    @AfterAll
    void cleanUp() {
    	System.out.println("finished first test cases");
    }

}






