package com.erhu.java.inetAddress;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    @Test
    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "什么时候才能找到工作？";
        byte[] data = str.getBytes();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),7758);
        socket.send(packet);

        socket.close();
    }
    @Test
    public void server() throws IOException {
        DatagramSocket ds = new DatagramSocket(7758);

        byte[] data = new byte[20];
        DatagramPacket dp = new DatagramPacket(data,0,data.length);
        ds.receive(dp);

        String string = new String(dp.getData(), 0, dp.getLength());
        System.out.println(string);

        ds.close();
    }
}
