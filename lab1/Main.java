package lab1;

public static class Main {

	public static void printShapeInfo(Shape s) {
		System.out.printf("%s with area %lf\n", s.draw(), s.calc_area());
	}

	public static void main(String args[]) {

		Rectangle r = new Rectangle(5, 7);
		Triangle t = new Triangle(1.6, 0.9);
		Circle c = new Circle(2);
		Square s = new Square(2.22);

		printShapeInfo(r);
		printShapeInfo(t);
		printShapeInfo(c);
		printShapeInfo(s);
	}
}