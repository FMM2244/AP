package lab1;

public class Square extends Rectangle {

	public Square(double s) {
		super(s, s);
		super.setName("Square");
	}

	public void setSide(double s) {
		super.length = s;
		super.width = s;
	}

	public String draw() {
		return "draw " + super.getName();
	}

	public double setSide() {
		return super.length;
	}
}
