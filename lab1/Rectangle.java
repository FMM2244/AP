package lab1;

public class Rectangle extends Shape {

	protected double length;
	protected double width;

	public Rectangle(double l, double w) {
		super("Rectangle");
		length = l;
		width = w;
	}

	public void setBase(double width) {
		this.width = width;
	}

	public String draw() {
		return "draw " + super.getName();
	}

	public double getBase(void) {
		return width;
	}

	public void setHeight(double length) {
		this.length = length;
	}

	public double getHeight(void) {
		return length;
	}

	public double calc_area() {
		return length * width;
	}
}
