package com.website.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketMultiServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2121);
			while ( true ) {
				Socket socket = server.accept();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
