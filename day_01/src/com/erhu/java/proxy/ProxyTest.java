package com.erhu.java.proxy;

/*
 * 动态代理
 * */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eatFood(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eatFood(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class ProxyFactory {
    //调用此方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;
    public void bind(Object obj){
       this.obj = obj;
    }
    //当通过代理类对象，调用方法A时，就会自动地调用invoke()方法
    //将代理类要执行的方法A的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method为代理类调用的方法，即为被代理类要调用的方法。
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human sp = (Human) ProxyFactory.getProxyInstance(superMan);
        sp.eatFood("麻辣烫");
        System.out.println(sp.getBelief());
    }
}
