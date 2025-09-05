package com.finalassignment.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for employee leave request features.
 *
 * NOTE: Replace the TODO sections with your concrete service classes
 * and map the dataset file names to match your project (copy them into src/test/resources).
 */
public class EmployeeLeaveRequestTests extends TestBase {

    @Test
    @Disabled("TODO: Map LeaveService and dataset file name before enabling")
    void TC01_requestLeave_valid_createsPending() throws Exception {
        Path leaves = copyResourceToTemp("LeaveRequest.txt"); // TODO: ensure filename matches your dataset

        // TODO: Replace with your actual service initialization, passing the temp file path
        // LeaveService svc = new LeaveService(leaves);

        // TODO: Replace with real call and types
        // LeaveRequest lr = svc.requestLeave("E123", "Vacation",
        //     LocalDate.of(2025, 9, 15), LocalDate.of(2025, 9, 20));

        // Example assertions to keep (adapt getters/fields as needed)
        // assertAll(
        //   () -> assertNotNull(lr.getLeaveId()),
        //   () -> assertEquals("E123", lr.getEmployeeId()),
        //   () -> assertEquals("Vacation", lr.getLeaveType()),
        //   () -> assertEquals(LocalDate.of(2025,9,15), lr.getStartDate()),
        //   () -> assertEquals(LocalDate.of(2025,9,20), lr.getEndDate()),
        //   () -> assertEquals("Pending", lr.getApprovalStatus())
        // );

        // Optionally: verify row appended in file
        // assertTrue(String.join("\n", readAll(leaves)).contains(lr.getLeaveId()));
        fail("TODO: Implement once services are mapped");
    }

    @Test
    @Disabled("TODO: Map LeaveService and dataset file name before enabling")
    void TC02_requestLeave_invalidDates_rejectedNoWrite() throws Exception {
        Path leaves = copyResourceToTemp("LeaveRequest.txt"); // TODO: ensure filename matches your dataset
        List<String> before = readAll(leaves);

        // TODO: Replace with your actual service initialization, passing the temp file path
        // LeaveService svc = new LeaveService(leaves);

        // assertThrows(IllegalArgumentException.class, () ->
        //     svc.requestLeave("E123", "Sick",
        //         LocalDate.of(2025, 9, 20), LocalDate.of(2025, 9, 15))
        // );
        // assertEquals(before, readAll(leaves)); // unchanged
        fail("TODO: Implement once services are mapped");
    }
}

