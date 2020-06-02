package com.erhu.java.thread;

class Account{
   private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void despoit(double num){
        if (num > 0){
            balance += num;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存入成功,当前余额为："+balance);
        }

    }
}

class Worker extends Thread{
    private Account acct;

    public Worker(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.despoit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Worker w1 = new Worker(account);
        Worker w2 = new Worker(account);
        w1.setName("甲");
        w2.setName("乙");
        w1.start();
        w2.start();
    }
}
