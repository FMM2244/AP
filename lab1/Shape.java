package lab1;

public abstract class Shape implements IDraw {

	protected String name;

	public Shape(String name) {
		this.name = name;
	}

	public abstract double calc_area();

	public void setName(String name) {
		this.name = name;
	}

	public string getName(void) {
		return name;
	}
}
