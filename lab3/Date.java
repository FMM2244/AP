
package lab3;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	String getDate() {
		return Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);
	}
}
