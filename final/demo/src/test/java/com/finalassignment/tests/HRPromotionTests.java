package com.finalassignment.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for HR promotions, including blocking terminated employees.
 */
public class HRPromotionTests extends TestBase {

    @Test
    @Disabled("TODO: Map HRService/Employee model and dataset file name before enabling")
    void TC07_promoteActive_updatesTitleAndDate() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset

        // HRService hr = new HRService(full, null, null);
        // Employee after = hr.promoteEmployee("E039","Senior Analyst", LocalDate.of(2025,9,5));
        // assertAll(
        //   () -> assertEquals("Senior Analyst", after.getJobTitle()),
        //   () -> assertEquals(LocalDate.of(2025,9,5), after.getLastPromotionDate()),
        //   () -> assertEquals("Active", after.getStatus())
        // );
        fail("TODO: Implement once services are mapped");
    }

    @Test
    @Disabled("TODO: Map HRService/Employee model and dataset file name before enabling")
    void TC08_promoteTerminated_blockedNoWrite() throws Exception {
        Path full = copyResourceToTemp("employees_full_time.txt"); // TODO: ensure filename matches your dataset
        List<String> before = readAll(full);

        // HRService hr = new HRService(full, null, null);
        // assertThrows(IllegalStateException.class, () ->
        //   hr.promoteEmployee("E032","Lead", LocalDate.now())
        // );
        // assertEquals(before, readAll(full));
        fail("TODO: Implement once services are mapped");
    }
}

