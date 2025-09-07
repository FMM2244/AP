/**
 * this is the proxy design pattern interface
 */

package com.finalassignment;

public interface IEmployeeAccess {
	boolean authenticate(String employeeId, String password);
	void getResponsibility();
}
