package com.basic.designmode.factory;

public class Factory {
    public static void main(String[] args) {
//        使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("程序结束");
    }
}

