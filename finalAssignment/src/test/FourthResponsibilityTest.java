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
import finalAssignment.HRResponsibilities;

class FourthResponsibilityTest {
	
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
    void TC007_promoteActiveEmployee() {
		
		emp = company.employees.get("E093");
    	// this segment of code will simulate the standard input of the user
        String simulatedInput = "3\n"
                              + "E2001\n"
                              + "2025-09-05\n"
                              + "Manager\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // this segment of code will simulate the standard output of the user
        // this will help assess weather the system prompts the correct statements 
        // when neccesary
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
        	((HRResponsibilities)company.service).promoteEmployee("E2001");;

            // converts output to string
            String output = outContent.toString();
            Employee temp = company.getEmployees().get("E2001");
            assertTrue(output.contains("Employee promoted successfully"));
            assertEquals("2025-09-05", temp.getLastPromotionDate());
        }
        finally {
            // back to original input and output streams
            System.setIn(System.in);
            System.setOut(originalOut);
        }
    }

    @Test
    void TC008_promoteTerminatedEmployee() {

    	emp = company.employees.get("E093");
    	// this segment of code will simulate the standard input of the user
        String simulatedInput = "3\n"
                              + "E2002\n"
                              + "2025-09-05"
                              + "Manager";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // this segment of code will simulate the standard output of the user
        // this will help assess weather the system prompts the correct statements 
        // when neccesary
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
        	((HRResponsibilities)company.service).promoteEmployee("E2002");;

            // converts output to string
            String output = outContent.toString();
            assertTrue(output.contains("Employee is Termineted"));
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
