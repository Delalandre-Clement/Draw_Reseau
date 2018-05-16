package Reseau;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("deprecation")

public class ZoneDessin extends Applet
{
	
	public void paint(Graphics g)
	{
		setBackground(Color.white);
		// Tracer une ligne rouge entre les points (x=5, y=30) et (x=50, y=70)
		g.setColor(Color.red);
		g.drawLine(5, 30, 50, 70);
		// Tracer un rectangle bleu (x=40, y=30, largeur=80, hauteur=50)
		g.setColor(Color.blue);
		g.drawRect(40, 30, 80, 50);
		// Tracer une ellipse verte (x=150, y=50, largeur=80, hauteur=30)
		g.setColor(Color.green);
		g.drawOval(150, 50, 80, 30);
		// Tracer un cercle jaune (x=200, y=20, largeur=hauteur=60)
		g.setColor(Color.yellow);
		g.drawOval(200, 20, 60, 60);
		// Tracer un rectangle aux coins arrondis
		// (x=105, y=15, largeur=60, hauteur=35, diamètre des coins=10)
		g.setColor(Color.orange);
		g.drawRoundRect(105, 15, 60, 35, 10, 10);
		// L'affichage de texte est traité de la même manière
		g.setColor(Color.white);
	}
	
	public void paint_ligne(Graphics g, Point depart, Point arrivee) {
		g.setColor(Color.black);
		g.drawLine(depart.getX(),depart.getY(), arrivee.getX(), arrivee.getY());
	}
}
