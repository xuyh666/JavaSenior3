package com.erhu.java.thread;

class Clerk{
     private int num = 0;

     public synchronized void produceProduct(){
         if (num < 20){
             num++;
             System.out.println(Thread.currentThread().getName()+"生产了第"+num+"件商品");
             notify();
         }else{
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
     public synchronized void consumeProduct(){
         if (num > 0){
             System.out.println(Thread.currentThread().getName()+"消费了第"+num+"件商品");
             num--;
             notify();
         }else {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}
class Producer extends Thread{
    Clerk c = new Clerk();

    public Producer(Clerk c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
       while (true){
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           c.produceProduct();
       }
    }
}
class Consumer  extends Thread{
    Clerk c = new Clerk();

    public Consumer(Clerk c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
       while (true){
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           c.consumeProduct();
       }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        consumer.setName("蒋芳芳");
        producer.setName("徐英豪");
        consumer.start();
        producer.start();
    }
}
