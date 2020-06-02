package com.erhu.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test(){
        List list = new ArrayList();
        list.add("AA");
        list.add("ZZ");
        list.add("CC");
        list.add("YY");
        list.add("MM");
        System.out.println(list);
        //Collections.reverse(list);//将list内的反转，不生成新的集合
        //Collections.shuffle(list);//将list集合随机排序
        //Collections.sort(list);//升序排序
        //Collections.sort(list, Comparator);//自定义排序
        //System.out.println(Collections.frequency(list, "AA"));//返回集合内指定出现的次数
        /*List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);//!!!!!!!使用时必须与源集合大小一致
        System.out.println(dest);*/
        //List list1 = Collections.synchronizedList(list);//返回线程安全的list
    }
}
