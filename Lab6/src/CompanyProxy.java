
public class CompanyProxy implements IManage {
	private static ArrayList<String> authorized;
	private Company com;

	static {
		authorized.add("HR");
		authorized.add("Owner");
		authorized.add("Employee1");
	}

	public void addItem(String key, Object item) {
		if (authorized.contains(key))
			com.addItem(key, item);
		else
			System.out.println("Unauthorized user ["+ key +"]");
	}

	public Object getItem(String key, Object keyItem) {
		if (authorized.contains(key))
			com.getItem(key, keyItem);
		else
			System.out.println("Unauthorized user ["+ key +"]");
	}

	public void Print(String key) {
		if (authorized.contains(key))
			com.Print(key);
		else
			System.out.println("Unauthorized user ["+ key +"]");
	}
}
