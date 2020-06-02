package com.erhu.java.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("AA");
        c.add("BB");
        c.add("CC");
        c.add("DD");
        c.add("EE");
        c.add("FF");
        Iterator i = c.iterator();
        while (i.hasNext()){
            //System.out.println(i.next());
            Object next = i.next();
            if ("CC".equals(next)){
                i.remove();
            }
            //System.out.println(i.next());
        }
        /*Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
    }

}
