package com.basic.designmode.factory;

public abstract class Pizza {
    protected String name;

    public abstract void prepare();
    public void bake(){
        System.out.println("baking"+name);
    }
    public void cut(){
        System.out.println("cutting"+name);
    }
    public void box(){
        System.out.println("boxing"+name);
    }
    public void setName(String name){
        this.name=name;
    }
}
