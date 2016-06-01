package com.jiangge.utils.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread implements Runnable{
    Socket socket = null;
    int id = 0;
    public ClientThread(Socket socket,int id){
        this.socket = socket;
        this.id = id;
    }
    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        System.out.println("Begin to Chat to server...");
        try {
            out = socket.getOutputStream();
            in = socket.getInputStream();
            doWrite(out);
//            System.out.println("begin read message from server.");
            doRead(in);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 读取服务端数据
     * @param in
     * @return
     */
    public static boolean doRead(InputStream in){
        //引用关系，不要在此处关闭流
        byte[] bytes = new byte[1024];
        try {
            in.read(bytes);
            System.out.println("line:"+new String(bytes).trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return true;
    }
    
    /**
     * 发送数据到服务端
     * @param out
     * @return
     */
    public boolean doWrite(OutputStream out){
        //引用关系，不要在此处关闭流
        String line = "Hello server, I am client = "+id +"\n";
        line = line +"I want you to do something for me";
        try {
            out.write(line.getBytes());
            out.flush();		
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
