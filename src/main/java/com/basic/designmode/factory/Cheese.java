package com.basic.designmode.factory;

public class Cheese extends Pizza {
    @Override
    public void prepare() {
        System.out.println("制作cheesePizza");
    }
}
