
package lab3;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {

		// instantiating 2 departments
		Department dep1 = new Department(10, "Sales");
		Department dep2 = new Department(20, "Research");

		// instantiating 4 employees
		Employee emp1 = new Employee("Ali", "Mecca Street", "Amman", 15, 12, 10, 1990, dep2);
		Employee emp1 = new Employee("Sami", "Alzaitona Street", "Amman", 23, 9, 5, 1987, dep2);
		Employee emp1 = new Employee("Leen", "Bagdad Street", "Irbid", 53, 23, 7, 1993, dep1);
		Employee emp1 = new Employee("Jehad", "Garden Street", "Amman", 7, 5, 7, 1991, dep1);

		// instantiating 3 projects
		Project p1 = new Project(1, "Product X", dep2);
		Project p2 = new Project(2, "Product Y", dep2);
		Project p3 = new Project(3, "Advertising", dep2);

		// instantiating an arraylist of records
		ArrayList<Record> table = new ArrayList<>();

		Record temp = new Record();
		temp.emp = emp2;
		temp.prj = p1;
		table.add(temp);

		Record temp = new Record();
		temp.emp = emp1;
		temp.prj = p1;
		table.add(temp);

		Record temp = new Record();
		temp.emp = emp2;
		temp.prj = p2;
		table.add(temp);

		Record temp = new Record();
		temp.emp = emp1;
		temp.prj = p2;
		table.add(temp);

		Record temp = new Record();
		temp.emp = emp3;
		temp.prj = p3;
		table.add(temp);

		System.out.println(table);
	}
}