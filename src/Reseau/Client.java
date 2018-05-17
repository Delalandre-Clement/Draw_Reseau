package Reseau;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame {
	
    	public Client () {
    		
    	}
    	
    	public static void main(String[] zero) {    
    		 
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        try {
                socket = new Socket(InetAddress.getLocalHost(),2009);   
                System.out.println("Demande de connexion");
                in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
                String message_distant = in.readLine(); 
                System.out.println(message_distant);
                message_distant = in.readLine();
                System.out.println(message_distant);  
                out = new PrintWriter(socket.getOutputStream());
                out.flush();
                out.println("o");
                out.flush();
              
                message_distant = in.readLine();
                System.out.println(message_distant);  
                socket.close();               
        }
        catch (UnknownHostException e) {
        	e.printStackTrace();
        }
        catch (IOException e) {            
            e.printStackTrace();
        }
    }
}

