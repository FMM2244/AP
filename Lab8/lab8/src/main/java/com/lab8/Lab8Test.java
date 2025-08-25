package com.lab8;

public class Lab8Test {
	
	private static Company com;
	
	@BeforeAll
	void setUpBeforeClass() {
		com = Company.singleton();
		com.addDept(new Department(10,"Sales"));
		com.addDept(new Department(20,"Research"));
		com.addEmp(EmployeeFactory.createEmployee("FullTime","ali",12,10,1990,15,"mecca","Amman",com.getDept(20),1500.98));
		com.addEmp(EmployeeFactory.createEmployee("FullTime","sami",9,5,1989,23,"alzaitona","Amman",com.getDept(20),1439.9));
		com.addEmp(EmployeeFactory.createEmployee("FullTime","leen",23,7,1993,53,"bagdad","Irbid",comy.getDept(10),1476.75));
		com.addEmp(EmployeeFactory.createEmployee("PartTime","jehad",5,7,1991,7,"garden","Amman",com.getDept(10),30));
		com.addProject(new Project(1,"Product x",com.getDept(20)));
		com.addProject(new Project(2,"Product y",com.getDept(20)));
		com.addProject(new Project(3,"Advertising",com.getDept(10)));
		com.addRecord(new Record(com.getEmp("sami"),com.getPrj(1)));
		com.addRecord(new Record(com.getEmp("ali"),com.getPrj(1)));
		com.addRecord(new Record(com.getEmp("sami"),com.getPrj(2)));
		com.addRecord(new Record(com.getEmp("ali"),com.getPrj(2)));
		com.addRecord(new Record(com.getEmp("leen"),com.getPrj(3)));
	}

	@Test
	void testSinglton() {
		System.out.println("inside testSinglton" + assertSame(com, com));
	}

	@Test
	void testGetEmployeeIfNull() {
		System.out.println("inside testSinglton" + assertNull(com.getEmp("fatima")));
	}

	@Test
	void testGetEmployeeIfNotNull() {
		System.out.println("inside testSinglton" + assertNotNull(com.getEmp("ali")));
	}

	@Test
	void testGetEmployeeIfNull() {
		System.out.println("inside testSinglton" + assertNotNull(com.getEmp("ali")));
	}
}