package Reseau;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {   

    public static void main(String[] zero) {
        ServerSocket socketserver  ;
        Socket socketduserveur ;
        BufferedReader in ;
        PrintWriter out;  
        try {
            socketserver = new ServerSocket(2009);
            System.out.println("Le serveur écoute le port "+socketserver.getLocalPort());
            socketduserveur = socketserver.accept(); 
                System.out.println("Un client s'est connecté");
                out = new PrintWriter(socketduserveur.getOutputStream());
                in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
                out.println("Vous êtes connecté  !");
                out.flush();
   
                
                out.println("Voulezzz vous jouer ?");
                out.flush();
                String message_distant = null;
                message_distant = in.readLine(); 
                System.out.println(message_distant);    
                         
                if (message_distant == "oui") {	
                    out.println("alors jouons");
                }
                else {out.println("nope");}
                out.flush();
                socketduserveur.close();
                socketserver.close();

        }
        catch (IOException e) {

            

            e.printStackTrace();

        }

    }


}


