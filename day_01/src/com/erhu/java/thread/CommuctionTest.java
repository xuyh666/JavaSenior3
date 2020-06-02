package com.erhu.java.thread;

class Numbers implements Runnable{

    private int n = 1;
    @Override
    public void run() {
       while (true){
           synchronized (this){
               notify();
               if (n <= 100){
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+":"+n);
                   n++;
               }else{
                   break;
               }
               try {
                   wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }
}

public class CommuctionTest {
    public static void main(String[] args) {
        Numbers n1 = new Numbers();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("AAA");
        t2.setName("BBB");
        t1.start();
        t2.start();
    }
}
