package com.erhu.java.inetAddress;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//客户端发送文件给服务器，服务器将文件保存到本地
public class TCPTest1 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9997);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("aaaa.jpg"));
        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1){
            os.write(data,0,len);
        }
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9997);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("a.jpg"));
        byte[] data = new byte[1024];
        int len;
        while ((len = is.read(data)) != -1){
            fos.write(data,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
