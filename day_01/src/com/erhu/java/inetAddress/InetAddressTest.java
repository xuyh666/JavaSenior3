package com.erhu.java.inetAddress;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    @Test
    public void test() throws UnknownHostException {
        InetAddress ia =InetAddress.getByName("192.168.0.104");
        System.out.println(ia);
        InetAddress ia1 = InetAddress.getByName("www.baidu.com");
        System.out.println(ia1);
        InetAddress ia2 = InetAddress.getByName("127.0.0.1");
        System.out.println(ia2);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(ia1.getHostName());
        System.out.println(ia1.getHostAddress());
    }
}
