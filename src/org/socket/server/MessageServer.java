package org.socket.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {

	public static void main(String[] args) {
		try {
		System.out.println("STARTING SERVER...");
		ServerSocket server=new ServerSocket(1989);
		Socket socket=server.accept();
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1="",s2="";
		while(!s1.equals("stop")){  
			s1=dis.readUTF();  
			System.out.println("Client Message: "+s1);  
			s2=br.readLine();  
			dos.writeUTF(s2);  
			dos.flush();  
			} 
		dis.close();  
		socket.close();  
		server.close();  
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
