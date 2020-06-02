package com.erhu.java.inetAddress;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9974);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("a.jpg"));
        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1){
            os.write(data,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[20];
        int len1;
        while ((len1 = is.read(bytes)) != -1){
            baos.write(bytes,0,len1);
        }
        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9974);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("b.jpg"));
        byte[] data = new byte[1024];
        int len;
        while ((len = is.read(data)) != -1){
            fos.write(data,0,len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("我同意。".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
