package com.erhu.java.collection;


import com.erhu.java.Eenum.SeasonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //add() 添加一个元素
        c.add("AA");
        c.add("BB");
        c.add("CC");
        c.add("11");
        c.add("CC1");
        c.add("22");
        c.add("33");
        System.out.println(c.size());
        Collection d = new ArrayList();
        d.add("11");
        d.add("22");
        d.add("33");
        //addAll()添加一个集合
        c.addAll(d);
        //size() 输出集合大小
        System.out.println(c.size());
        //clear() 清空集合内元素
        d.clear();
        //isEmpty() 是否为空
        System.out.println(d.isEmpty());
        //contains() 是否包含 一个一个比较
        c.add(new String("666"));
        c.add(new SeasonTest("aaa"));
        System.out.println(c.contains("AA"));
        System.out.println(c.contains(new SeasonTest("aaa")));//如果没有重写equal(),则为false
        System.out.println(c.contains(new String("666")));//true
        //containsAll() 是否包含某个集合
        Collection e = Arrays.asList("BB","CC");
        System.out.println(c.containsAll(e));
        //remove()  删除数据
        System.out.println(c);
        c.remove("CC1");
        System.out.println(c);
        //removeAll() 移除所有
        Collection ss = Arrays.asList("11");
        c.removeAll(ss);
        System.out.println(c);
        //retainAll() 求交集并返回给当前集合
        Collection sss = Arrays.asList("22", "33");
        System.out.println(c);
        c.retainAll(sss);
        System.out.println(c);
        //equals() 判断集合是否相等
        Collection ccc = Arrays.asList("22","33","22","33");
        System.out.println(c.equals(ccc));
        //hashCode() 返回当前方法的哈希值
        System.out.println(c.hashCode());
        //toArray() 集合变数组
        Object[] objects = c.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        //数组变集合 Arrays.aslist()
        List<String> strings = Arrays.asList(new String[]{"11", "22"});
        System.out.println(strings);
    }
}
