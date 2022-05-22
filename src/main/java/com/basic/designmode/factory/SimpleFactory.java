package com.basic.designmode.factory;

//简单工厂只是用来创建不同类型的对象的
public class SimpleFactory {
    public Pizza createPizza(String type){
        Pizza pizza=null;
        System.out.println("使用简单工厂模式");
        if (type.equals("cheese")){
//            System.out.println("cheese was new ");
            pizza=new Cheese();
            pizza.setName("奶酪披萨");
        }
        else if(type.equals("greek")){
            pizza=new greek();
            pizza.name="希腊披萨";
        }

        return pizza;
    }
}