package com.erhu.java.string;

public class test {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        String c = new String("aaa");
        String d = new String("aaa");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(a == d);
        System.out.println(a.equals(d));
    }
}
