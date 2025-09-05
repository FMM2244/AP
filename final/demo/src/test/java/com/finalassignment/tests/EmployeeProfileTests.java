package com.finalassignment.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for employee profile view/update features.
 *
 * NOTE: Replace the TODO sections with your concrete service classes
 * and map the dataset file names to match your project (copy them into src/test/resources).
 */
public class EmployeeProfileTests extends TestBase {

    @Test
    @Disabled("TODO: Map EmployeeService and dataset file name before enabling")
    void TC03_viewProfile_readsFromCorrectTypeFile() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset

        // TODO: Replace with your actual service initialization (full, part, contract)
        // EmployeeService svc = new EmployeeService(full, /*part*/null, /*cont*/null);
        // Employee e = svc.viewEmployee("E052");
        // assertAll(
        //   () -> assertNotNull(e),
        //   () -> assertEquals("E052", e.getId()),
        //   () -> assertEquals("Full-time", e.getEmploymentType())
        // );
        fail("TODO: Implement once services are mapped");
    }

    @Test
    @Disabled("TODO: Map EmployeeService and dataset file name before enabling")
    void TC04_updatePhone_persistsToFile() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset

        // TODO: Replace with your actual service initialization (full, part, contract)
        // EmployeeService svc = new EmployeeService(full, null, null);
        // svc.updatePhone("E052", "0791234567");
        // Employee again = svc.viewEmployee("E052");
        // assertEquals("0791234567", again.getPhoneNumber());
        fail("TODO: Implement once services are mapped");
    }
}

