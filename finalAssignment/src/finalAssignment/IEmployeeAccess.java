package finalAssignment;

public interface IEmployeeAccess {
	boolean authenticate(String employeeId, String password);
    void getResponsibility();
}
