// package lab8;
package com.lab8;


public class Date implements Cloneable {
	private int day;
	private int month;
	private int year;
	
	public Date(int d,int m,int y)
	{
		day=d;
		month=m;
		year=y;		
	}
	public void set_Date(int d,int m,int y)
	{
		day=d;
		month=m;
		year=y;		
	}
	public String Get_Date()
	{
		String date_Str=new String();
		date_Str=day+"/"+month+"/"+year;
		return date_Str;
	}
	
	public Date clone()throws CloneNotSupportedException
	{
		return (Date)super.clone();
	}
}
