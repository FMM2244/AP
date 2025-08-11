import java.util.ArrayList;
public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Company myCompany=new Company();
		
		myCompany.addItem("Department",new Department(10,"Sales"));
		myCompany.addItem("Department",new Department(20,"Research"));
		
		myCompany.addItem("Employee",new Employee("ali",12,10,1990,15,"mecca","Amman",(Department)myCompany.getItem("Department",20)));
		myCompany.addItem("Employee",new Employee("sami",9,5,1989,23,"alzaitona","Amman",(Department)myCompany.getItem("Department",20)));
		myCompany.addItem("Employee",new Employee("leen",23,7,1993,53,"bagdad","Irbid",(Department)myCompany.getItem("Department",10)));
		myCompany.addItem("Employee",new Employee("jehad",5,7,1991,7,"garden","Amman",(Department)myCompany.getItem("Department",10)));
		
		
		myCompany.addItem("Project",new Project(1,"Product x",(Department)myCompany.getItem("Department",20)));
		myCompany.addItem("Project",new Project(2,"Product y",(Department)myCompany.getItem("Department",20)));
		myCompany.addItem("Project",new Project(3,"Advertising",(Department)myCompany.getItem("Department",10)));
		
		myCompany.addItem("Record",new Record((Employee)myCompany.getItem("Employee","sami"),(Project)myCompany.getItem("Project",1)));
		myCompany.addItem("Record",new Record((Employee)myCompany.getItem("Employee","ali"),(Project)myCompany.getItem("Project",1)));
		myCompany.addItem("Record",new Record((Employee)myCompany.getItem("Employee","sami"),(Project)myCompany.getItem("Project",2)));
		myCompany.addItem("Record",new Record((Employee)myCompany.getItem("Employee","ali"),(Project)myCompany.getItem("Project",2)));
		myCompany.addItem("Record",new Record((Employee)myCompany.getItem("Employee","leen"),(Project)myCompany.getItem("Project",3)));
		
		myCompany.Print("Department");
		myCompany.Print("Employee");
		myCompany.Print("Project");
		myCompany.Print("Record");
		

	}

}
