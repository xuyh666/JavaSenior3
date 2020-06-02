package com.erhu.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将线程需要实现的基本操作生命在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
           if (i % 2 == 0){
               System.out.println(i);
               sum+=i;
           }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3.创建callable接口实现类对象
        NumThread numThread = new NumThread();
        //4.将Callable实现类对象作为传递到FutureTask构造器中创建构造器对象。
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，调用start()方法。
        new Thread(futureTask).start();
        try {
            //6.获取callable中call()方法的返回值
            //get()的返回值即为FutureTask构造器参数callable实现类重写的call()的返回值
            Object o = futureTask.get();
            System.out.println("总和为"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
