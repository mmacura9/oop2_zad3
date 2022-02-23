package igra;

import java.awt.Color;

public abstract class KruznaFigura extends Krug {

	protected Vektor brzina;
	protected Scena scena;

	public KruznaFigura(Vektor centar, Color boja, double poluprecnik, Vektor brzina, Scena scena) {
		super(centar, boja, poluprecnik);
		this.brzina = brzina;
		this.scena = scena;
	}

	public void pomeri(double t) {
		Vektor pom = Vektor.pomnozi(brzina, t);
		centar = Vektor.saberi(centar, pom);
	}

	public synchronized void vanScene() {
		if(centar.getY()>scena.getHeight() ||
				centar.getX()> scena.getWidth() || centar.getX()<0)
			scena.izbaciFiguru(this);
	}
	
}
