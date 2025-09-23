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


class FifthResponsibilityTest {

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
    void TC009_createNewEmployee() {
		
		emp = company.employees.get("E093");
    	// this segment of code will simulate the standard input of the user
        String simulatedInput = "1\n"
                              + "E3001\n"
                              + "1\n"
                              + "Ali Ahmad\n"
                              + "2004-04-22\n"
                              + "Male\n"
                              + "ali@gmail.com\n"
                              + "0791294545\n"
                              + "2025-09-05\n"
                              + "Engineer\n"
                              + "1\n"
                              + "Active\n"
                              + "2025-09-20\n"
                              + "AA123456789\n"
                              + "1200\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // this segment of code will simulate the standard output of the user
        // this will help assess weather the system prompts the correct statements 
        // when neccesary
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
        	((HRResponsibilities)company.service).addEmployee("E3001");;

            // converts output to string
            String output = outContent.toString();
            assertTrue(output.contains("Employee Added successfully"));
            assertNotNull(company.employees.get("E3001"));
        }
        finally {
            // back to original input and output streams
            System.setIn(System.in);
            System.setOut(originalOut);
        }
    }

    @Test
    void TC010_addDuplicateEmployee() {
		emp = company.employees.get("E093");
    	// this segment of code will simulate the standard input of the user
        String simulatedInput = "1\n"
                              + "E3001\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // this segment of code will simulate the standard output of the user
        // this will help assess weather the system prompts the correct statements 
        // when neccesary
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
        	((HRResponsibilities)company.service).addEmployee("E3001");;

            // converts output to string
            String output = outContent.toString();
            assertTrue(output.contains("Invalid employee ID, employee already exists"));
            assertNotNull(company.employees.get("E3001"));
        }
        finally {
            // back to original input and output streams
            System.setIn(System.in);
            System.setOut(originalOut);
        }
    }
    
    @AfterAll
    void cleanUp() {
    	System.out.println("finished fifth test cases");
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
