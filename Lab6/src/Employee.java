
public class Employee {
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
	public Employee(Employee emp)
	{
		name=emp.Get_Name();
		BDate=new Date(emp.BDate.getDay(),emp.BDate.getMonth(),emp.BDate.getYear());
		Home_Address=new Address(emp.Home_Address.getBld_No(),emp.Home_Address.getStreet(),emp.Home_Address.getCity());
		Dept=emp.Dept;
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
