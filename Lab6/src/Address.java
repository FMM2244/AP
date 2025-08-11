
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
	public int getBld_No() {
		return Bld_No;
	}
	public void setBld_No(int bld_No) {
		Bld_No = bld_No;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
}
