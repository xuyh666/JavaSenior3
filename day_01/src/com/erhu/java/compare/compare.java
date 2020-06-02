package com.erhu.java.compare;

import java.util.Arrays;
import java.util.Comparator;

public class compare {
    public static void main(String[] args) {
        String[] s = {"AA", "KK", "GG", "BB", "MM"};
       /*
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));*/
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(s));
    }
}
