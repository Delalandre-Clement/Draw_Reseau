package Reseau;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Draw extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

	/**
	 * Create the application.
	 */
	public Draw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.setBounds(404, 322, 127, 20);
		textField.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(404, 0, 127, 316);
		textArea.setEnabled(false);

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(404, 348, 127, 23);
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setText(textField.getText());
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(textArea);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnEnvoyer);

		Panel panel = new Panel();
		panel.setBounds(10, 328, 373, 33);
		frame.getContentPane().add(panel);

		JToggleButton tglbtnLigne = new JToggleButton("Ligne");
		panel.add(tglbtnLigne);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle);

		JToggleButton tglbtnCercle = new JToggleButton("Cercle");
		panel.add(tglbtnCercle);


		ZoneDessin	zone_dessin = new ZoneDessin();
		zone_dessin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point point_depart = new Point(e.getX(),e.getY());
				Point point_arrive = new Point(e.getX()+20,e.getY()+20);
				Graphics g = zone_dessin.getGraphics();
				zone_dessin.paint_ligne(g, point_depart, point_arrive);
			}			
		});
		zone_dessin.setBounds(10, 11, 373, 305);
		frame.getContentPane().add(zone_dessin);
		frame.setVisible(true);

	}
	
	void setText(String message) {
		textArea.append("\n\r" + message);
		textField.setText(null);
	}
	
	void connexion(Socket socket, BufferedReader in, PrintWriter out) {
		this.socket=socket;
		this.in=in;
		this.out=out;
		try {
			String message_distant = this.in.readLine();
			setText(message_distant);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
}


