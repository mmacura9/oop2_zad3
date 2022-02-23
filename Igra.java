package igra;

import java.awt.*;
import java.awt.event.*;

public class Igra extends Frame {

	private Scena scena = new Scena(this);
	private Label rec = new Label("[TEXTO] _____");
	private Panel panel = new Panel();
	
	public Igra() {
		super("Baloni");
		setSize(500, 500);

		add(scena, BorderLayout.CENTER);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(rec);
		add(panel, BorderLayout.EAST);
		
		setVisible(true);

		scena.pokreni();
		dodajListenere();
	}

	private void dodajListenere() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				scena.zaustavi();
			}

		});

	}

	public static void main(String[] args) {
		new Igra();
	}

}
