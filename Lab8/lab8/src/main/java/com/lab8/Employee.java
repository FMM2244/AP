// package lab8;
package com.lab8;


public abstract class Employee implements IEmployee{
	private String name;
	private Date BDate;
	private Address Home_Address;
	private Department Dept;
		
	public Employee(String nm,int d,int m,int y,int bld,String str, String ct,Department dpt)
	{
		name=nm;
		BDate=new Date(d,m,y);
		Home_Address=new Address(bld,str,ct);
		Dept=dpt;
		
	}
	
	public String Get_Name()
	{
		return name;
	}
	public String Get_BDate()
	{
		if(BDate==null)
			return "";
		return BDate.Get_Date();
	}
	public String Get_Address()
	{
		if(Home_Address==null)
			return "";
		return Home_Address.Get_Address();
	}
	public String Get_department()
	{
		if(Dept==null)
			return "";
		return Dept.getName();
	}
	
}
