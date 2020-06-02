package com.erhu.java.collection;

import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test(){
        
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",123);
        map.put("CC",666);
        map.put(123,1234);
        map.put("DD",123);
        Set set = map.keySet();//获取所有的KEY值
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        Collection values = map.values();//获取所有的value值
        Iterator iterator1 = values.iterator();
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println();
        Set set1 = map.entrySet();//获取所有的entry对象
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.println(entry.getKey()+"----方式一---->"+entry.getValue());
        }
        Set keySet = map.keySet();//获取所有的KEY值
        Iterator it = keySet.iterator();
        while (it.hasNext()){
            Object next = it.next();
            Object o = map.get(next);
            System.out.println(next+"-----方式二-----"+o);
        }
    }
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("AA",123);//添加
        map.put("BB",123);
        map.put("CC",666);
        map.put(123,1234);
        map.put("DD",123);
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("AAA",123);
        map1.put("BB",123);
        map1.put("af","af");
        map.putAll(map1);//添加一个集合
        System.out.println(map);
        map.remove("AA");//删除一个
        System.out.println(map);
        map1.clear();//清空结合
        System.out.println(map1);
        System.out.println(map.get(123));//根据KEY获取值
        System.out.println(map.containsKey("AA"));//是否包含指定的Key
        System.out.println(map.containsValue(1234));//是否包含指定value
        System.out.println(map.size());//返回元素个数
        System.out.println(map1.isEmpty());//返回是否为空
        Map map2 = new HashMap();
        map2.putAll(map);
        System.out.println(map.equals(map2));//判断集合是否相等

        List<? extends Person> l = null;//<=
        List<? super Person> l2 = null;//>=
       /* l.add(new Person());
        l.add(new Student());
        l.add(new Object());
        l2.add(new Person());
        l2.add(new Student());
        l2.add(new Object());*/
    }
}
