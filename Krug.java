package igra;

import java.awt.*;

public class Krug {
	protected Vektor centar;
	protected Color boja;
	protected double poluprecnik;

	public Krug(Vektor centar, Color boja, double poluprecnik) {
		super();
		this.centar = centar;
		this.boja = boja;
		this.poluprecnik = poluprecnik/2;
	}

	public boolean preklapajuSe(Krug k) {
		Vektor negk = new Vektor(-k.centar.getX(), -k.centar.getY());
		Vektor razCent = Vektor.saberi(centar, negk);
		double raz = Math.sqrt(razCent.getX() * razCent.getX() + razCent.getY() * razCent.getY());
		if (raz < poluprecnik + k.poluprecnik)
			return true;
		return false;
	}

	public void iscrtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()-poluprecnik), (int)(centar.getY()-poluprecnik), (int)(2*poluprecnik), (int)(2*poluprecnik));
	}

}
