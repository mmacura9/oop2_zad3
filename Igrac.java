package igra;

import java.awt.*;

public class Igrac extends KruznaFigura {

	public Igrac(Vektor centar, double poluprecnik, Scena scena) {
		super(centar, Color.GREEN, poluprecnik, new Vektor(0, 0), scena);
	}

	@Override
	public void pomeri(double t) {
		brzina = new Vektor(t, 0);
		super.pomeri(10);
		if(vanSceneB()) {
			brzina = new Vektor(-t, 0);
			super.pomeri(10);
		}
	}

	
	@Override
	public void iscrtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()-poluprecnik), (int)(centar.getY()-poluprecnik), (int)(2*poluprecnik), (int)(2*poluprecnik));
		g.setColor(Color.BLUE);
		g.fillOval((int)(centar.getX()-poluprecnik/2), (int)(centar.getY()-poluprecnik/2), (int)poluprecnik, (int)poluprecnik);
		
	}
	
	@Override
	public void vanScene() {
		
	}
	
	public boolean vanSceneB() {
		if(centar.getX()+poluprecnik> scena.getWidth() || centar.getX()-poluprecnik<0)
			return true;
		return false;
	}
	
}
