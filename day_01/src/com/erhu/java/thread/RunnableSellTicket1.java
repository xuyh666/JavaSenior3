package com.erhu.java.thread;

class SellTickets implements Runnable {
    private int num = 250;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {//同步监视器为this
        if (num > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "::" + num);
            num--;
        }
    }
}

public class RunnableSellTicket1 {
    public static void main(String[] args) {
        SellTickets sellTicket = new SellTickets();

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
