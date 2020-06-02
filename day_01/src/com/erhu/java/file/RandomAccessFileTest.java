package com.erhu.java.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test//RandomAccessFile实现插入操作
    public void test2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("h.txt", "rw");
        raf.seek(3);
        StringBuilder stringBuilder = new StringBuilder((int) new File("h.txt").length());
        byte[] data = new byte[20];
        int len;
        while ((len = raf.read(data)) != -1){
            stringBuilder.append(new String(data,0,len));
        }
        raf.seek(3);
        raf.write("erhu".getBytes());
        raf.write(stringBuilder.toString().getBytes());
    }
    @Test
    public void test1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("h.txt"), "rw");
        raf.seek(3);//降至选中在3位置
        raf.write("bbb".getBytes());
        raf.close();
    }
    @Test//图片复制
    public void test(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("aaaa.jpg"), "r");
            raf1 = new RandomAccessFile(new File("abab.jpg"), "rw");
            byte[] data = new byte[1024];
            int len;
            while ((len = raf.read(data)) != -1){
                raf1.write(data,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
