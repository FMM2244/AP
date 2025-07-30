
package lab3;

public class Project {
	private int no;
	private String name;
	private Department dept;

	public Project(int no, String name, Department dept) {
		this.no = no;
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
}
