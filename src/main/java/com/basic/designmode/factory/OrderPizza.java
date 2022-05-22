package com.basic.designmode.factory;

import java.util.Scanner;

public class OrderPizza {
    SimpleFactory simpleFactory;
    Pizza pizza=null;

    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    public void setSimpleFactory(SimpleFactory simpleFactory){
        String type="";
        Scanner in=new Scanner(System.in);
        this.simpleFactory=simpleFactory;
        do {
            type=in.next();
            pizza=this.simpleFactory.createPizza(type);
            if (pizza!=null){
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("~~订购失败~~");
                break;
            }
        }while(true);
    }
}
