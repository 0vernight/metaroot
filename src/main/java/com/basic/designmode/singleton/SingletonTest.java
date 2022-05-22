package com.basic.designmode.singleton;

public class SingletonTest {
    
    public static void main(String[]args){
        Singleton instace1=Singleton.getInstance();
        Singleton instace2=Singleton.getInstance();
        System.out.println(instace1==instace2);

        SingletonLazy instance3=SingletonLazy.getInstance();
        SingletonLazy instance4=SingletonLazy.getInstance();
        System.out.println(instance3==instance4);

    }
}

//饿汉式的单列模式
//1构造器的私有化
//2类内部创建对象实例
//3提供一个共有的对象方法,返回对象实例
class Singleton {
    private Singleton() {
    }
    private final static Singleton instance=new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

class SingletonLazy{
    public static volatile SingletonLazy instance;
    private SingletonLazy(){}

    public static SingletonLazy getInstance() {
        if (instance==null){
            synchronized (SingletonLazy.class){
                if (instance==null)
                    instance=new SingletonLazy();
            }
        }
        return instance;
    }
}