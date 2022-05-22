package com.basic.designmode.factory;

public class greek extends Pizza{
    @Override
    public void prepare() {
        System.out.println("制作greek Pizza");
    }
}
