package Reseau;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JSlider;
import java.awt.Panel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Draw {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Draw window = new Draw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Draw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.setBounds(428, 322, 103, 20);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(428, 0, 103, 316);
		textArea.setEnabled(false);

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(428, 348, 103, 23);
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("\n\r" + textField.getText());
				textField.setText(null);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(textArea);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnEnvoyer);

		Panel panel = new Panel();
		panel.setBounds(10, 328, 408, 33);
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
		zone_dessin.setBounds(10, 11, 408, 305);
		frame.getContentPane().add(zone_dessin);
		
	}
}


