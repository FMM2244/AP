package com.finalassignment;

public class ProxyAuthenticator implements IEmployeeAccess {

	private Employee requester;

    public ProxyAuthenticator() {}

    @Override
    public boolean authenticate(String employeeId, String password) {
        Company company = Company.getInstance();

        if (company.getEmployees() == null || !company.getEmployees().containsKey(employeeId)) {
            System.out.println("Invalid employee ID!");
            return false;
        }

        requester = company.getEmployees().get(employeeId);

        if (requester.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + requester.getFullName());
            return true;
        } else {
            System.out.println("Invalid password!");
            return false;
        }
    }

    @Override
    public void getResponsibility() {
        if (requester == null) {
            System.out.println("No authenticated user!");
            return;
        }

        String role = requester.getRole();

        switch (role) {
            case "HR":
                System.out.println("Redirecting to HR portal...");
                // call HR service
                break;
            case "Manager":
                System.out.println("Redirecting to Manager portal...");
                // call Manager service
                break;
            case "Employee":
                System.out.println("Redirecting to Employee portal...");
                // call Employee service
                break;
            default:
                System.out.println("Unknown role!");
        }
    }

    // Getter and Setter
    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }
}
