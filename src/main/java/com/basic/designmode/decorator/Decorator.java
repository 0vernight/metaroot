package com.basic.designmode.decorator;

public class Decorator extends Drink{
    public Drink obj;
    public Decorator(Drink obj){
        this.obj=obj;
    }
    @Override
    public float cost() {
        return super.getPrice()+obj.getPrice();
    }

    @Override
    public String getDes() {
        return des+" "+super.getPrice()+"&&"+obj.getPrice();
    }
}
