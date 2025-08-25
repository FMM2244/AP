// package lab8;
package com.lab8;

public class Lab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Company myCompany=Company.singleton();
		
		myCompany.addDept(new Department(10,"Sales"));
		myCompany.addDept(new Department(20,"Research"));
		
		myCompany.addEmp(EmployeeFactory.createEmployee("FullTime","ali",12,10,1990,15,"mecca","Amman",myCompany.getDept(20),1500.98));
		myCompany.addEmp(EmployeeFactory.createEmployee("FullTime","sami",9,5,1989,23,"alzaitona","Amman",myCompany.getDept(20),1439.9));
		myCompany.addEmp(EmployeeFactory.createEmployee("FullTime","leen",23,7,1993,53,"bagdad","Irbid",myCompany.getDept(10),1476.75));
		myCompany.addEmp(EmployeeFactory.createEmployee("PartTime","jehad",5,7,1991,7,"garden","Amman",myCompany.getDept(10),30));
		
		
		myCompany.addProject(new Project(1,"Product x",myCompany.getDept(20)));
		myCompany.addProject(new Project(2,"Product y",myCompany.getDept(20)));
		myCompany.addProject(new Project(3,"Advertising",myCompany.getDept(10)));
		
		myCompany.addRecord(new Record(myCompany.getEmp("sami"),myCompany.getPrj(1)));
		myCompany.addRecord(new Record(myCompany.getEmp("ali"),myCompany.getPrj(1)));
		myCompany.addRecord(new Record(myCompany.getEmp("sami"),myCompany.getPrj(2)));
		myCompany.addRecord(new Record(myCompany.getEmp("ali"),myCompany.getPrj(2)));
		myCompany.addRecord(new Record(myCompany.getEmp("leen"),myCompany.getPrj(3)));
		
		myCompany.Print("Department");
		myCompany.Print("Employee");
		myCompany.Print("Project");
		myCompany.Print("Record");

	}

}
