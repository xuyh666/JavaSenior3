package com.erhu.java.thread;

class SellTickets1 extends Thread{
    private static int num = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public static synchronized void show(){//同步监视器为this
            if (num > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+num);
                num--;
            }
        }
    }
public class ThreadSellTicket1 {
    public static void main(String[] args) {
        SellTickets1 sellTicket1 = new SellTickets1();
        SellTickets1 sellTicket2 = new SellTickets1();
        SellTickets1 sellTicket3 = new SellTickets1();
        sellTicket1.setName("aaa");
        sellTicket2.setName("bbb");
        sellTicket3.setName("ccc");
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();
    }
}
