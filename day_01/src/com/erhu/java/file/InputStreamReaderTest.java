package com.erhu.java.file;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    @Test//InputStreamReader
    public void test1() throws IOException {
        //1.造文件、造流
        File file = new File("h.txt");
        File file1 = new File("h4.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file1);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //2.读文件
        char[] data = new char[20];
        int len;
        while ((len = isr.read(data)) != -1){
            osw.write(data,0,len);
        }
        //3.关流
        isr.close();
        osw.close();
    }
    @Test //InputStreamReader练习
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("h.txt");
        //InputStreamReader isr = new InputStreamReader(fis);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        char[] c = new char[20];
        int len;
        StringBuilder builder = new StringBuilder();
        while ((len = isr.read(c)) != -1){
            //String s = new String(c, 0, len);
            builder.append(c,0,len);
        }
        System.out.println(builder);
        isr.close();
    }
}
