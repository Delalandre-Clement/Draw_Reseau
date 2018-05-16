package Reseau;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("deprecation")

public class ZoneDessin extends Applet
{
	
	public void paint(Graphics g)
	{
		setBackground(Color.white);

	}
	
	public void paint_ligne(Graphics g, Point depart, Point arrivee) {
		g.setColor(Color.black);
		g.drawLine(depart.getX(),depart.getY(), arrivee.getX(), arrivee.getY());
	}
}
