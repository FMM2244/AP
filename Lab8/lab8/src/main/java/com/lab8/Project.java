// package lab8;
package com.lab8;


public class Project {
	private int ID;
	private String name;
	private Department Dept;
	
	public Project(int id,String nm,Department dpt)
	{
		ID=id;
		name=nm;
		Dept=dpt;
	}
	public String Get_Name()
	{
		return name;
	}
	public int getID()
	{
		return ID;
	}

}
