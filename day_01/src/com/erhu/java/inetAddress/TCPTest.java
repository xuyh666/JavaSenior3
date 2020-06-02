package com.erhu.java.inetAddress;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//客户端发送内容给服务器，服务其将其打印到控制台
public class TCPTest {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建socket对象，指明服务器端ip和端口号
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ia,8899);
            //2.获取输出流，输出数据
            os = socket.getOutputStream();
            //3.拿出数据操作
            os.write("我要年薪百万，老天爷!!!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务端socket,指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

        /*//容易乱吗
        byte[] data = new byte[20];
        int len;
        while ((len = is.read(data)) != -1){
            System.out.println(new String(data,0,len));
        }*/
            //4.读数据
            baos = new ByteArrayOutputStream();
            byte[] data = new byte[20];
            int len;
            while ((len = is.read(data)) != -1){
                baos.write(data,0,len);
            }
            System.out.println(socket.getInetAddress().getHostAddress()+":"+baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
