package com.erhu.java.Eenum;
interface Info{
    public  final int a = 0;
    public abstract void show();
}

enum  Season1 implements Info{
     SPRING("春天","春暖花开"){
         @Override
         public void show() {
             System.out.println("春天 春暖花开");
         }
     },
     SUMMER("夏天","夏日炎炎") {
         @Override
         public void show() {
             System.out.println("夏天 夏日炎炎");
         }
     },
     AUTUMN("秋天","秋高气爽") {
         @Override
         public void show() {
             System.out.println("秋天 秋高气爽");
         }
     },
     WINTER("冬天","冬风凛冽") {
         @Override
         public void show() {
             System.out.println("冬天 冬风凛冽");
         }
     };

    private final String seasonName;
    private final String seasonDesc;

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /*@Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/
}

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println("******************************************");
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        System.out.println("**********************************************");
        Thread.State[] states = Thread.State.values();
        for (Thread.State state : states) {
            System.out.println(state);
        }
        System.out.println("**********************************************");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        System.out.println("**********************************************");
        Season1 summer = Season1.SUMMER;
        Season1 automn = Season1.valueOf("AUTUMN");
        summer.show();
        automn.show();
    }
}
