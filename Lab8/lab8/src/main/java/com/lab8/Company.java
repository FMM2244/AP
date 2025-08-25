package com.lab8;

// package lab8;

import java.util.ArrayList;

public class Company {
	private static Company instance=null;
	
	private ArrayList<Department> Dept_List;
	private ArrayList<Employee> Emp_List;
	private ArrayList<Project> Prj_List;
	private ArrayList<Record> RCD_List;
	
	public static Company singleton()
	{
		if(instance==null)
			instance=new Company();
		return instance;
	}
	
	private Company(){
		Dept_List=new ArrayList<Department>();
		Emp_List=new ArrayList<Employee>();
		Prj_List=new ArrayList<Project>();
		RCD_List=new ArrayList<Record>();	
	}
	
	public void addDept(Department dept) {
		Dept_List.add(dept);
	}
	public void addEmp(Employee emp) {
		Emp_List.add(emp);
	}
	public void addProject(Project prj) {
		Prj_List.add(prj);
	}
	public void addRecord(Record rcd) {
		RCD_List.add(rcd);
	}
	public Department getDept(int id) {
		for(int i=0;i<Dept_List.size();i++)
		{
			if (id==Dept_List.get(i).getID())
				return Dept_List.get(i);
		}
		return null;
	}
	public Employee getEmp(String name) {
		for(int i=0;i<Emp_List.size();i++)
		{
			if(Emp_List.get(i).Get_Name().equals(name))
				return Emp_List.get(i);
		}
		return null;
	}
	public Project getPrj(int id) {
		for(int i=0;i<Prj_List.size();i++)
		{
			if(id==Prj_List.get(i).getID())
				return Prj_List.get(i);
		}
		return null;
	}
	
	public boolean worksOnProject(String name)
	{
		for(Record r:RCD_List)
			if(name.equals(r.Emp.Get_Name()))
				return true;
		return false;
	}
	public void Print(String key)
	{
		switch(key)
		{
		case "Department":
			for(Department D:Dept_List)
			{
				System.out.println(D.getID()+"\t"+D.getName());
			}
			break;
			
		case "Employee":
			for(Employee e:Emp_List)
			{
				System.out.println(e.Get_Name()+"\t"+e.Get_Address()+"\t"+e.Get_BDate()+"\t"+((IEmployee)e).getSalary()+"\t"+worksOnProject(e.Get_Name()));
			}
			break;
			
		case "Project":
			for(Project p:Prj_List)
			{
				System.out.println(p.getID()+"\t"+p.Get_Name());
			}
			break;
			
		case "Record":
			for(Record r:RCD_List)
			{
				System.out.println(r.Emp.Get_Name()+"\t"+r.Prj.Get_Name());
			}
			break;
		default:
			System.out.println("Wrong List Name");
			
		}
	}
	

}
