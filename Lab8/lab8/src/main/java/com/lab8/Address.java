// package lab8;
package com.lab8;



public class Address {
	private int Bld_No;
	private String Street;
	private String City;
	
	public Address(int n,String str,String ct)
	{
		Bld_No=n;
		Street=str;
		City=ct;
	}
	public void Set_Address(int n,String str,String ct)
	{
		Bld_No=n;
		Street=str;
		City=ct;
	}
	
	public String Get_Address()
	{
		return Bld_No+" "+Street+" "+City;
	}
}
