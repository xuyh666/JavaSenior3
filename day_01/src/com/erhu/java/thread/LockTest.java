package com.erhu.java.thread;


import java.util.concurrent.locks.ReentrantLock;
//如果是继承，则ReentrantLock声明为static
class LockThread implements Runnable{

    private int num = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (num > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num--;
                }else{
                    break;
                }
            }finally {
               lock.unlock();
            }
        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        Thread t1 = new Thread(lockThread);
        Thread t2 = new Thread(lockThread);
        Thread t3 = new Thread(lockThread);
        t1.setName("aaa");
        t2.setName("bbb");
        t3.setName("ccc");
        t1.start();
        t2.start();
        t3.start();
    }
}
