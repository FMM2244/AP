package com.finalassignment.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for HR creation of full-time employee and duplicate ID handling.
 */
public class HREmployeeCreationTests extends TestBase {

    @Test
    @Disabled("TODO: Map HRService/Employee model and dataset file name before enabling")
    void TC09_createFullTime_writesAllRequiredFields() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset

        // HRService hr = new HRService(full, null, null);
        // Employee e = new Employee(/* id */"E3001", /* name */"Ali Ahmad" /* ... other required fields ... */);
        // Employee saved = hr.createFullTimeEmployee(e);

        // String file = String.join("\n", readAll(full));
        // assertAll(
        //   () -> assertTrue(file.contains("E3001")),
        //   () -> assertTrue(file.contains("Ali Ahmad")),
        //   () -> assertTrue(file.contains("Full-time"))
        //   // Add asserts for every required attribute present in the row
        // );
        fail("TODO: Implement once services are mapped");
    }

    @Test
    @Disabled("TODO: Map HRService/Employee model and dataset file name before enabling")
    void TC10_createDuplicateId_blockedNoDuplicateRow() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset
        List<String> before = readAll(full);

        // HRService hr = new HRService(full, null, null);
        // Employee existing = hr.viewEmployee("E052");
        // Employee dup = new Employee("E052", existing.getFullName() /* ... */);
        // assertThrows(IllegalArgumentException.class, () -> hr.createFullTimeEmployee(dup));
        // assertEquals(before, readAll(full));
        fail("TODO: Implement once services are mapped");
    }
}

