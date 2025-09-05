package com.finalassignment.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for manager approvals/rejections of leave requests.
 */
public class ManagerLeaveDecisionTests extends TestBase {

    @Test
    @Disabled("TODO: Map ManagerService/LeaveService and dataset file name before enabling")
    void TC05_approveLeave_updatesStatusApproved() throws Exception {
        Path leaves = copyResourceToTemp("LeaveRequest.txt"); // TODO: ensure filename matches your dataset

        // LeaveService leaveSvc = new LeaveService(leaves);
        // ManagerService mgr = new ManagerService(leaves);
        // LeaveRequest lr = leaveSvc.requestLeave("E123","Vacation",
        //     LocalDate.of(2025,10,1), LocalDate.of(2025,10,3));
        // LeaveRequest upd = mgr.approveLeave(lr.getLeaveId());
        // assertEquals("Approved", upd.getApprovalStatus());
        fail("TODO: Implement once services are mapped");
    }

    @Test
    @Disabled("TODO: Map ManagerService/LeaveService and dataset file name before enabling")
    void TC06_rejectLeave_updatesStatusRejected() throws Exception {
        Path leaves = copyResourceToTemp("LeaveRequest.txt"); // TODO: ensure filename matches your dataset

        // LeaveService leaveSvc = new LeaveService(leaves);
        // ManagerService mgr = new ManagerService(leaves);
        // LeaveRequest lr = leaveSvc.requestLeave("E123","Sick",
        //     LocalDate.of(2025,9,10), LocalDate.of(2025,9,12));
        // LeaveRequest upd = mgr.rejectLeave(lr.getLeaveId());
        // assertEquals("Rejected", upd.getApprovalStatus());
        fail("TODO: Implement once services are mapped");
    }
}

