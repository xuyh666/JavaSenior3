package com.erhu.java.thread;

class SellTicket1 extends Thread{
    private static int num = 100;
    @Override
    public void run() {
        while (true){
            synchronized (SellTicket1.class){
                if (num > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+":"+num);
                    num--;
                }else{
                    break;
                }
            }
        }
    }
}

public class ThreadSellTicket {
    public static void main(String[] args) {
        SellTicket1 sellTicket1 = new SellTicket1();
        SellTicket1 sellTicket2 = new SellTicket1();
        SellTicket1 sellTicket3 = new SellTicket1();
        sellTicket1.setName("aaa");
        sellTicket2.setName("bbb");
        sellTicket3.setName("ccc");
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();
    }
}
