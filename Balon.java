package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Balon extends KruznaFigura {

	private char znak;
	
	public Balon(Vektor centar, double poluprecnik, Vektor brzina, Scena scena) {
		super(centar, Color.RED, poluprecnik, brzina, scena);
		znak = (char)('A' + (int)(Math.random()*('Z'-'A')));
	}

	
	@Override
	public void iscrtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()-poluprecnik), (int)(centar.getY()-poluprecnik), (int)(2*poluprecnik), (int)(2*poluprecnik));
		g.setColor(Color.BLACK);
		g.drawString(""+znak, (int)centar.getX(), (int)centar.getY());
	}
}
