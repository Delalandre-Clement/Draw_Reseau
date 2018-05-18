package Reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket socketserver;
		Socket socketduserveur;
		BufferedReader in;
		PrintWriter out;
		int nombre_client=0;
		int num_socket=2000;
		while(nombre_client <2) {
			try {
				socketserver = new ServerSocket(num_socket);
				System.out.println("Le serveur ecoute le port "+ socketserver.getLocalPort());
				socketduserveur = socketserver.accept(); 
				System.out.println("Un client s'est connecte");
				/*
				out = new PrintWriter(socketduserveur.getOutputStream());
				out.println("Vous etes connecte  !");
				out.flush();
				*/
				num_socket++;
				nombre_client++;
			}
			catch (IOException e) {
				e.printStackTrace();

			}
		}
		/*
			try {


				socketduserveur.close();
				socketserver.close();
			}
			catch (IOException e) {
				e.printStackTrace();

			}
		 */
	}

	public void send(String message) {

	}

	public void receive(String message) {

	}
}