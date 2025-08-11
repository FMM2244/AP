
public class FullTimeEmployee extends Employee {
	private double salary;
	
	public FullTimeEmployee(String nm,int d,int m,int y,int bld,String str, String ct,Department dpt, double slr)
	{
		super(nm,d,m,y,bld,str,ct,dpt);
		salary=slr;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
