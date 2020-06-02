package com.erhu.java.collection;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    @Test
    public void test1(){
        //自定义排序
        TreeMap map = new TreeMap(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if(Integer.compare(o1.getAge(),o2.getAge()) == 0){
                    return o1.getName().compareTo(o2.getName());
                }else{
                    return Integer.compare(o1.getAge(),o2.getAge());

                }
            }
        });
        Person p = new Person("A",51);
        Person p1 = new Person("G",52);
        Person p2 = new Person("B",511);
        Person p3 = new Person("A",11);
        Person p4 = new Person("Z",16);
        Person p5 = new Person("O",16);
        map.put(p,23);
        map.put(p1,23);
        map.put(p2,23);
        map.put(p3,23);
        map.put(p4,23);
        map.put(p5,21);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey()+"---->"+next.getValue());
        }
    }

    @Test
    public void test(){
        //自然排序
        TreeMap map = new TreeMap();
        Person p = new Person("A",51);
        Person p1 = new Person("G",52);
        Person p2 = new Person("B",511);
        Person p3 = new Person("A",11);
        Person p4 = new Person("Z",16);
        map.put(p,23);
        map.put(p1,23);
        map.put(p2,23);
        map.put(p3,23);
        map.put(p4,23);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey()+"---->"+next.getValue());
        }
    }
}
