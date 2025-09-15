package com.finalassignment.tests;
import org.junit.jupiter.api.*;

import com.finalassignment.Employee;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {

    // === First responsibility: Request Leave ===
    @Test
    void TC001_requestValidLeave() {
        Employee emp = new Employee("E1001");
        boolean result = emp.requestLeave("vacation", "2025-09-20", "2025-09-25");
        assertTrue(result, "Leave request should be logged as pending");
        assertEquals("pending", emp.getLeaveStatus("2025-09-20", "2025-09-25"));
    }

    @Test
    void TC002_requestInvalidLeave() {
        Employee emp = new Employee("E1001");
        boolean result = emp.requestLeave("vacation", "2025-09-20", "2025-08-20");
        assertFalse(result, "Invalid leave request should not be logged");
    }

    // === Second responsibility: View and Update personal Data ===
    @Test
    void TC003_viewPersonalData() {
        Employee emp = new Employee("E1001");
        String profile = emp.viewProfile();
        assertNotNull(profile, "Profile should display all employee details");
    }

    @Test
    void TC004_updatePersonalData() {
        Employee emp = new Employee("E1001");
        boolean updated = emp.updatePhone("0791294848");
        assertTrue(updated, "Phone number should be updated successfully");
        assertEquals("0791294848", emp.getPhone(), "Phone number should reflect the new number");
    }

    // === Third responsibility: Approve, Decline or Delay leave request ===
    @Test
    void TC005_approvePendingLeave() {
        Manager mgr = new Manager("M1001");
        boolean approved = mgr.processLeave("L1001", "approved");
        assertTrue(approved, "Leave request should be approved");
        assertEquals("approved", mgr.getLeaveStatus("L1001"));
    }

    @Test
    void TC006_rejectPendingLeave() {
        Manager mgr = new Manager("M1001");
        boolean rejected = mgr.processLeave("L1002", "rejected");
        assertTrue(rejected, "Leave request should be rejected");
        assertEquals("rejected", mgr.getLeaveStatus("L1002"));
    }

    // === Fourth responsibility: Promote Employee ===
    @Test
    void TC007_promoteActiveEmployee() {
        HR hr = new HR("HR1001");
        boolean promoted = hr.promoteEmployee("E2001", "Senior Engineer", "2025-09-05");
        assertTrue(promoted, "Active employee should be promoted");
        Employee emp = hr.getEmployee("E2001");
        assertEquals("Senior Engineer", emp.getJobTitle());
        assertEquals("2025-09-05", emp.getLastPromotionDate());
    }

    @Test
    void TC008_promoteTerminatedEmployee() {
        HR hr = new HR("HR1001");
        boolean promoted = hr.promoteEmployee("E2002", "Team Lead", "2025-09-05");
        assertFalse(promoted, "Terminated employee cannot be promoted");
    }

    // === Fifth responsibility: Create New Employee ===
    @Test
    void TC009_createNewEmployee() {
        HR hr = new HR("HR1001");
        Employee newEmp = new Employee("E3001", "Ali Ahmad", "2004-04-22", "male", "ali@gmail.com",
                                       "0791294545", "Engineer", "D01", "Active", "2025-09-20", "AA123456789", 1200);
        boolean created = hr.addEmployee(newEmp);
        assertTrue(created, "New employee should be added successfully");
        assertEquals(newEmp, hr.getEmployee("E3001"));
    }

    @Test
    void TC010_addDuplicateEmployee() {
        HR hr = new HR("HR1001");
        Employee duplicateEmp = new Employee("E3001", "Someone Else", "2000-01-01", "female", "someone@gmail.com",
                                             "0791111111", "Engineer", "D01", "Active", "2025-09-20", "AA123456789", 1000);
        boolean created = hr.addEmployee(duplicateEmp);
        assertFalse(created, "Duplicate employee should not be added");
    }
}
