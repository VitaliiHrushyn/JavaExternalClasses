package ua.testing.labr05.model;

public class Model {
	
	private Parabola parabola;

	public Model() {
		super();
	}

	public Parabola getParabola() {
		return parabola;
	}

	public void createParabola(int a, int b, int c) {
		this.parabola = new Parabola(a, b, c);
	}
	
}
