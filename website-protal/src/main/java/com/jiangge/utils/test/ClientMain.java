package com.jiangge.utils.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) {
        Socket socket = null;
        System.out.println("ClientSocket Begin........");
        try {
            for(int i = 0;i<15000;i++){
                socket = new Socket("127.0.0.1", 4567);
                new Thread(new ClientThread(socket,i),"ClientThread "+i).start();
            }
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
