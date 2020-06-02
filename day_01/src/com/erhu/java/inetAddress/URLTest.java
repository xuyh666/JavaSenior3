package com.erhu.java.inetAddress;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void test1() {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/car.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();

            fos = new FileOutputStream("car.jpg");
            byte[] data = new byte[20];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                fos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {

                try {
                    urlConnection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/car.jpg?username=erhu");
        System.out.println("协议名：" + url.getProtocol());//协议名
        System.out.println("主机名：" + url.getHost());//主机名
        System.out.println("端口号：" + url.getPort());//端口号
        System.out.println("文件路径：" + url.getPath());//文件路径
        System.out.println("文件名：" + url.getFile());//文件名
        System.out.println("查询名：" + url.getQuery());//查询名
    }
}
