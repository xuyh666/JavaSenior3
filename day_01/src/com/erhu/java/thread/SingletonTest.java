package com.erhu.java.thread;

public class SingletonTest {
}
class  Bank{
    private Bank(){}
    private static Bank bank = null;
    public static Bank getInstance(){
        //方式一：效果较差
       /* synchronized (Bank.class) {
            if (bank == null){
                bank = new Bank();
            }
            return bank;
        }*/
       if (bank == null){
           synchronized (Bank.class) {
               if (bank == null){
                   bank = new Bank();
               }
           }
       }
        return bank;
    }
}