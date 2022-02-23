package igra;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Scena extends Canvas implements Runnable {

	private Igra igra;
	private Thread nit;
	private Igrac igrac;
	private ArrayList<Balon> baloni = new ArrayList<>();

	public Scena(Igra igra) {
		this.igra = igra;
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					igrac.pomeri(1);
					break;
				case KeyEvent.VK_LEFT:
					igrac.pomeri(-1);
					break;
				}
			}
		});
	}

	private Balon generisiBalon() {
		int width = getWidth();
		int x = (int) (width * Math.random());
		Vektor centar = new Vektor(x, 0);
		return new Balon(centar, 20, new Vektor(0, 1), this);
	}

	public Igrac getIgrac() {
		return igrac;
	}

	public void ubaciFiguru(KruznaFigura f) {
		if (f instanceof Balon)
			baloni.add((Balon) f);
		if (f instanceof Igrac)
			igrac = (Igrac) f;
	}

	public synchronized void izbaciFiguru(KruznaFigura f) {
		if (f instanceof Balon && baloni.contains(f)) {
			baloni.remove(f);
		}
		if (igrac == f)
			igrac = null;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Thread.sleep(60);
				if (Math.random() <= 0.1)
					ubaciFiguru(generisiBalon());
				synchronized (this) {
					for (int i = 0; i < baloni.size(); i++) {
						if (igrac.preklapajuSe(baloni.get(i)))
							zaustavi();
						baloni.get(i).pomeri(10);
						baloni.get(i).vanScene();
					}
				}
				repaint();
			}
		} catch (InterruptedException e) {
		}
	}

	private Igrac generisiIgraca() {
		int height = getHeight();
		int width = getWidth() / 2;
		Vektor centar = new Vektor(width, 7 * height / 8);
		return new Igrac(centar, 30, this);
	}

	private boolean pokrenuta = false;

	public void pokreni() {
		if (pokrenuta == false) {
			pokrenuta = true;
			nit = new Thread(this);
			ubaciFiguru(generisiIgraca());
			nit.start();
			requestFocus();
		}
	}

	public void zaustavi() {
		if (pokrenuta == true) {
			pokrenuta = false;
			nit.interrupt();
		}
	}

	@Override
	public void paint(Graphics g) {
		if(igrac != null)
			igrac.iscrtaj(this);
		for (Balon b : baloni)
			b.iscrtaj(this);
	}

}
