package com.basic.javaKang.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 23236
 * @createTime: 2022/4/3   15:48
 * @description: 动态代理
 *
 *
 **/
interface  Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I belie i can fly ";
    }

    @Override
    public void eat(String food) {
        System.out.println("as a powerful man i dont need to eat food even"+food);
    }
}
/*
* 根据加载到内存当中的类来加载动态的加载一个类。
* 通过动态的调用代理类的方法
* 怎么调用动态的代理类看如下:
* 也就是说动态代理类你不去写每个被代理类的代理类而是通过反射动态生成任何类的代理类
* */
class ProxyFactory{

    public static Object getProxyInstance(Object obj){  //被代理类的对象
        //动态的去制造代理类obj
        //要通过调用反射下的方法
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        return proxyInstance;
    }

}
class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }
    //通过代理类的对象来调用方法时会自动调用如下方法。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        //即为代理类调用的方法
        Object invokeResult = method.invoke(obj, args);
        humanUtil.method2();

        return invokeResult;
    }
}
class HumanUtil{
    public void method1(){
        System.out.println("__________方法一__________");
    }
    public void method2(){
        System.out.println("__________方法二__________");
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        //被代理类
        SuperMan superMan = new SuperMan();
        //代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        String belief=proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("testy healthys food");

        //---------与静态代理类做个对比
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeFactory);
        proxyInstance1.produceCloth();

    }

}
