package com.erhu.java.collection;

import com.erhu.java.Eenum.SeasonTest;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        //Set set = new HashSet();
        Set set = new LinkedHashSet();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add(new SeasonTest("村田"));
        set.add("11");
        set.add("22");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        String a = "1";
        String b = "1";

        System.out.println(a == b);
    }
}
