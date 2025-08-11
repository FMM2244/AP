
public class PartTimeEmployee extends Employee {
	private int hoursPerWeek;
	
	public PartTimeEmployee(String nm,int d,int m,int y,int bld,String str, String ct,Department dpt, int hpw)
	{
		super(nm,d,m,y,bld,str,ct,dpt);
		hoursPerWeek=hpw;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

}
