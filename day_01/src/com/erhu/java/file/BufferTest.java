package com.erhu.java.file;

import org.junit.Test;

import java.io.*;

public class BufferTest {
    @Test// BufferedReader String
    public void test1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("h.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("h2.txt")));
        String str;
        while ((str = br.readLine()) != null){
            bw.write(str);
        }
        br.close();
        bw.close();
    }

    @Test//BufferedInputStream byte[]
    public void test(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            //造文件
            File file = new File("aaaa.jpg");
            File file1 = new File("aaaaa1.jpg");
            //造缓冲流
            fi = new FileInputStream(file);
            fo = new FileOutputStream(file1);
            //造节点流
            bi =new BufferedInputStream(fi);
            bo = new BufferedOutputStream(fo);
            byte[] bytes = new byte[5];
            int len;
            while ((len = bi.read(bytes)) != -1){
                bo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //缓冲流关闭时自动关闭节点流
            if(bi != null){
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bo != null){
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
