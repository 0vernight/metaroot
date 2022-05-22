package com.basic.designmode.decorator;

public class CoffeeBar {
    public static void main(String[] args) {

        Drink order=new LongBlack();
        System.out.println("fee"+order.cost());
        System.out.println("des="+order.getDes());

        order=new Milk(order);
        System.out.println("fee"+order.cost());
        System.out.println("des="+order.getDes());

        order=new Chocolate(order);
        System.out.println("fee"+order.cost());
        System.out.println("des="+order.getDes());
    }
}
