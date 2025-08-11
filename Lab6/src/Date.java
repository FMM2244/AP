
public class Date {
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
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String Get_Date()
	{
		String date_Str=new String();
		date_Str=day+"/"+month+"/"+year;
		return date_Str;
	}
}
