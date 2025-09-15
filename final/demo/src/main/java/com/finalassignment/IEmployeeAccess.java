/**
 * this is the proxy design pattern
 */

package com.finalassignment;

public interface IEmployeeAccess {
	boolean authenticate(String employeeId, String password);
    void getResponsibility();
}
