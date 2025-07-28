package lab1;

public class Circle extends Shape {

	protected double radius;
	private double PI = 3.14159;

	public Circle(double r) {
		super("Circle");
		radius = r;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius(void) {
		return radius;
	}

	public String draw() {
		return "draw " + super.getName();
	}

	public double calc_area() {
		return radius * radius * PI;
	}
}
