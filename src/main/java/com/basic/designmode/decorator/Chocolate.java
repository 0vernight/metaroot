package com.basic.designmode.decorator;

public class Chocolate extends Decorator{
    public Chocolate(Drink obj){
        super(obj);
        setDes("chocolate");
        setPrice(4.0f);
    }
}
