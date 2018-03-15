package ua.testing.labr05.model;

/**
 * Class Parabola provides a parody (unfortunately) on calculations of double y 
 * for known x with integers a, b and c. 
 */

public class Parabola implements Cloneable {
	
	private int a; // a != 0
	private int b;
	private int c;
	
	public Parabola() {
		super();
		setA(1);
		setB(0);
		setC(0);
	}
	
	public Parabola(int a, int b, int c) {
		super();
		setA(a);
		setB(b);
		setC(c);
	}	

	public int getA() {
		return a;
	}

	public void setA(int a)  {
		if (validateA(a)) {
			this.a = a;
		}
	}
	
	public boolean validateA(int a) throws IllegalArgumentException {
		if (a == 0) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	/*Should be use in x calculations but such method isn't present here yet*/
	private int calculateD() {
		return b * b - 4 * a * c;
	}

	/*As far as I know this method could be used just with valid x values */
	public double getYwhenXis(double x) {
		return a * Math.pow(x, 2.0) + b * x + c;
	}	

	@Override
	public Object clone() throws CloneNotSupportedException {
			return super.clone();
		 }
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (object.getClass() == this.getClass()) {
			Parabola temp = (Parabola) object;
			return (this.a == temp.a && this.b == temp.b && this.c == temp.c);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (int) ((a * 31 + b) * 31) + c;
	}

	@Override
	public String toString() {
		return "Parabola with: a=" + a + ", b=" + b + ", c=" + c + ".";
	}

}
