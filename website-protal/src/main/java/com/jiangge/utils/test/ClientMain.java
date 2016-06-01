package com.jiangge.utils.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import com.jiangge.utils.task.TaskPoolManager;

public class ClientMain {
	public static void main(String[] args) {
        Socket socket = null;
        System.out.println("ClientSocket Begin........");
        try {
        	String begintime = new Date().toString();
            for(int i = 0;i<150000;i++){
                socket = new Socket("127.0.0.1", 4567);
//                new Thread(new ClientThread(socket,i),"ClientThread "+i).start();
                TaskPoolManager.newInstance().addTask(socket,i);
            }
            System.out.println(begintime + "\n" + new Date().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
