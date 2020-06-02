package com.erhu.java.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //treeset添加的类型必须一样
        TreeSet set = new TreeSet();
        set.add(new Person("aa",1));
        set.add(new Person("ac",42));
        set.add(new Person("kaka",22));
        set.add(new Person("c",55));
        set.add(new Person("zzzz",24));
        set.add(new Person("e",13));
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Comparator ct = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };
        System.out.println("*****************************");
        TreeSet set1 = new TreeSet(ct);
        set1.add(new Person("aa",1));
        set1.add(new Person("ac",42));
        set1.add(new Person("kaka",22));
        set1.add(new Person("c",55));
        set1.add(new Person("zzzz",24));
        set1.add(new Person("e",13));
        Iterator it = set1.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
