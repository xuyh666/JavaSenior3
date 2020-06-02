package com.erhu.java.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    @Test//创建目录
    public void test6(){
        File file = new File("D:\\IDEA\\test\\OI\\aa");
        //如果父目录不存在，则不创建
        if(file.mkdir()){
            System.out.println("创建成功");
        }
        File file1 = new File("D:\\IDEA\\test\\IO\\aa");
        if (file1.mkdirs()){
            System.out.println("ok");
        }
    }
    @Test//创建删除txt
    public void test5() throws IOException {
        File file = new File("a.txt");
        if (!file.exists()){
            //创建文件
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            //删除文件
            file.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test4(){
        //File file = new File("hello.txt");
        File file = new File("D:\\IDEA\\test");
        System.out.println(file.isDirectory());//是否是文件目录
        System.out.println(file.isFile());//是否是文件
        System.out.println(file.exists());//是否存在
        System.out.println(file.canRead());//是否可读
        System.out.println(file.canWrite());//是否可写
        System.out.println(file.isHidden());//是否隐藏
    }
    @Test//改名
    public void test3(){
        //file1真实存在，file2不能存在
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\IDEA\\test\\h.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
    @Test//遍历目录下所有文件
    public void test2(){
        File file = new File("D:\\IDEA\\IDEA\\IDEAWorkspace\\JavaSenior");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\IDEA\\test\\hello.txt");
        System.out.println(file1.getAbsolutePath());//获取绝对路径
        System.out.println(file1.getPath());//相对路径
        System.out.println(file1.getName());//获取文件名
        System.out.println(file1.getParent());//获取父路径
        System.out.println(file1.length());//文件长度
        System.out.println(new Date(file1.lastModified()));//获取文件被修改的时间

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test(){
        File file1 = new File("hello.txt");
        System.out.println(file1);
        File file2 = new File("D:\\IDEA\\test\\hello.txt");
        System.out.println(file2);
        File file3 = new File("D:\\IDEA\\test", "test1.txt");
        System.out.println(file3);
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);
    }
}
