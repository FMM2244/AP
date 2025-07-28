package lab1;

public class Triangle extends Shape {
	
	protected double height;
	protected double base;

	public Triangle(double b, double h) {
		super("Triangle");
		height = h;
		base = b;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public String draw() {
		return "draw " + super.getName();
	}

	public double getBase(void) {
		return base;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight(void) {
		return height;
	}

	public double calc_area() {
		return 0.5 * height * base;
	}
}
