package com.erhu.java.file;

import org.junit.Test;

import java.io.*;

public class FileRenderTest {


    @Test//复制txt
    public void test3(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file1 = new File("h.txt");
            File file2 = new File("h1.txt");
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            char[] c = new char[5];
            int a;
            while((a = fr.read(c)) != -1){
               fw.write(c,0,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test//追加写入文件
    public void test2(){
        FileWriter writer = null;
        try {
            //提供file对象，指明file文件
            File file = new File("h.txt");
            //提供Filewriter对象，用于数据写出
            writer = new FileWriter(file,true);
            //数据写出
            writer.write("hello darling\n");
            writer.write("hello love");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    //流关闭
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            char[] c = new char[5];
            int len;
            //read(char[])返回每次读入的个数，达到末尾返回1
            while ((len = fileReader.read(c)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(c[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test() {
        FileReader fd = null;
        try {
            //实例化对象
            File file = new File("hello.txt");
            //提供具体的流
            fd = new FileReader(file);
            /*int data = fd.read();//返回一个字符
            while (data != -1){
                System.out.println((char)data);
                data = fd.read();
            }*/
            int data;
            //数据读入 返回的是每次读入的数据
            while ((data = fd.read()) != -1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            try {
                if (fd == null)
                    fd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
