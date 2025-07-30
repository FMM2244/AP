
package lab3;

public class Address {
	private int bldNum;
	private String street;
	private String city;

	public Address() {
		bldNum = 0;
		street = "";
		city = "";
	}

	public Address(int bldNum, String street, String city) {
		this.bldNum = bldNum;
		this.street = street;
		this.city = city;
	}

	public void setAddress(int bldNum, String street, String city) {
		this.bldNum = bldNum;
		this.street = street;
		this.city = city;
	}

	public String getAddress() {
		return Integer.toString(bldNum) + ", " + street + ", " + city;
	}
}
