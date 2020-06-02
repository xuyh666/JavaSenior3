package com.erhu.java.thread;

class SellTicket implements Runnable{
    //Object obj = new Object();
    private int num = 250;
    @Override
    public void run() {
       while (true){
           //synchronized (obj){
           synchronized (this){
               if (num > 0){
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+":"+num);
                   num--;
               }else {
                   break;
               }
          }
       }
    }
}

public class RunnableSellTicket {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();

        Thread thread1 = new Thread(sellTicket);
        Thread thread2 = new Thread(sellTicket);
        Thread thread3 = new Thread(sellTicket);

        thread1.setName("AAA");
        thread2.setName("BBB");
        thread3.setName("CCC");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
