package com.erhu.java.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test //反射之前 不可以调用私有
    public void beforerf(){
        Person p = new Person("徐英豪", 23);
        System.out.println(p);
        p.setAge(10);
        System.out.println(p.toString());
        p.show();
    }
    @Test//反射实现
    public void nowrf() throws Exception{

        Class clazz = Person.class;
        //创建对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);//获取构造器
        Object jff = constructor.newInstance("蒋芳芳", 24);
        Person p = (Person) jff;
        System.out.println(p);
        //通过反射获取属性方法
        //调属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        //调方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //调私有构造器、方法、属性
        //私有构造器
        Constructor priva = clazz.getDeclaredConstructor(String.class);
        priva.setAccessible(true);
        Person o = (Person) priva.newInstance("小明");
        System.out.println(o);
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"小芳");
        System.out.println(o);
        //私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String rt = (String) showNation.invoke(o, "CHINA");
        System.out.println(rt);
    }
}
