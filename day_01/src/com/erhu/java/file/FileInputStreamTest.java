package com.erhu.java.file;

import org.junit.Test;

import java.io.*;

public class FileInputStreamTest {
    @Test//图片解密
    public void test3(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File("bbbb.jpg");
            File file1 = new File("cccc.jpg");
            fi = new FileInputStream(file);
            fo = new FileOutputStream(file1);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fi.read(bytes)) != -1){
                //不能用foreach,因为foreach是新造一个数组 for (byte aByte : bytes)
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test//图片加密
    public void test2() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File("aaaa.jpg");
            File file1 = new File("bbbb.jpg");
            fi = new FileInputStream(file);
            fo = new FileOutputStream(file1);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fi.read(bytes)) != -1){
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test//复制视频
    public void test1(){
        long s = System.currentTimeMillis();
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File("C:\\Users\\Erhu\\Desktop\\新建文件夹\\m\\a.mp4");
            File file1 = new File("C:\\Users\\Erhu\\Desktop\\新建文件夹\\m\\b.mp4");
            fi = new FileInputStream(file);
            fo = new FileOutputStream(file1);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fi.read(bytes)) != -1){
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
    @Test//实现对图片复制
    public void test(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File("aaaa.jpg");
            File file1 = new File("aaaaa.jpg");
            fi = new FileInputStream(file);
            fo = new FileOutputStream(file1);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fi.read(bytes)) != -1){
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
