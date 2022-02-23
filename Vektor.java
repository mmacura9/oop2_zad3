package igra;

public class Vektor implements Cloneable {
	public double x, y;

	public Vektor(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public static Vektor pomnozi(Vektor v, double vr) {
		return new Vektor(v.x * vr, v.y * vr);
	}

	public static Vektor saberi(Vektor v1, Vektor v2) {
		return new Vektor(v1.x + v2.x, v1.y + v2.y);
	}

	@Override
	public Vektor clone() {
		try {
			return (Vektor) super.clone();
		} catch (CloneNotSupportedException g) {
			return null;
		}
	}

}
