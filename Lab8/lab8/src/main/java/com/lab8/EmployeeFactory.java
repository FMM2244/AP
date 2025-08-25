// package lab8;
package com.lab8;


public class EmployeeFactory {
	public static Employee createEmployee(String type,String nm,int d,int m,int y,int bld,String str, String ct,Department dpt,Object var) {
		Employee emp=null;
		if(type.equals("PartTime"))
		{
			emp=new PartTimeEmployee(nm,d,m,y,bld,str,ct,dpt,(int)var);
		}
		else if(type.equals("FullTime"))
		{
			emp=new FullTimeEmployee(nm,d,m,y,bld,str,ct,dpt,(double)var);
		}
		return emp;
	}

}
