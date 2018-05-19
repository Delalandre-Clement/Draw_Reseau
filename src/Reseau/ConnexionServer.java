package Reseau;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class ConnexionServer {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionServer window = new ConnexionServer();
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
	public ConnexionServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 278, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP");
		
		JLabel lblPort = new JLabel("Port");
		
		JSpinner spinner = new JSpinner();
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        Socket socket;
		        BufferedReader in;
		        PrintWriter out;
				 try {
					 	System.out.print(InetAddress.getLocalHost());
		                socket = new Socket(InetAddress.getByName(textField.getText()), (int)spinner.getValue());   
		                System.out.println("Demande de connexion");
		                
		                
		                /*
		                 * Recuperation du message du serveur
		                 
		                in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		                String message_distant = in.readLine(); 
		                System.out.println(message_distant);
		                message_distant = in.readLine();
		                System.out.println(message_distant);  
		                */
		                /*
		                 * Envoi d'un message au serveur
		                 
		           		out = new PrintWriter(socket.getOutputStream());
		                out.flush();	// Vide le flux d'entrée
		                out.println("o");
		                out.flush();
		                //String message_distant = in.readLine();
		                System.out.println(message_distant);
		                socket.close();	// Fermeture du socket
		                 */
		                Draw joueur = new Draw();
		                //joueur.connexion(socket, in, out);
		                joueur.setText("Connexion reussie");
		                joueur.setText("Attente joueur ...");
		                //frame.setVisible(false);
		        }
		        catch (UnknownHostException e) {
		        	e.printStackTrace();
		        }
		        catch (IOException e) {            
		            e.printStackTrace();
		        }
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPort)
						.addComponent(lblAdresseIp))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConnexion)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresseIp)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPort)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConnexion)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
