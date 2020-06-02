package com.erhu.java.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
        list.add("11");
        list.add("AA");
        System.out.println(list);
        //add(index,obj); 插入
        list.add(0,666);
        System.out.println(list);
        //addAll(index,list) 添加所有元素
        List strings = Arrays.asList("!!", "..");
        list.addAll(1,strings);
        System.out.println(list);
        //indexOf(obj)  返回首次出现位置,如果不存在返回-1
        System.out.println(list.indexOf("AA"));
        //lastIndexOf(obj) 返回末次出现的索引
        System.out.println(list.lastIndexOf("AA"));
        //remove(num或obj) 删除指定位置索引 或者删除指定对象
        Object ob = list.remove(1);//返回被删除元素
        System.out.println(ob);
        System.out.println(list);
        //set(index,obj) 修改角标处元素为obj
        list.set(0,"xu");
        System.out.println(list);
        //subList(index,index); 返回区间内元素
        System.out.println(list.subList(2, 5));
        //String a = new String("a");
        StringBuilder aaa = new StringBuilder("aaa");
        aaa.append("1");
        aaa.append("2");
        aaa.append("3");
        aaa.delete(0,3);
        System.out.println("---"+aaa);
    }
}
