package com.basic.designmode.Test;

public class test01 {
    public static void main(String[] args) {

        Father father=new Child();



        String s1="hello";
        String s2="he"+"llo";
        System.out.println(s1.equals(s2));
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        System.out.println("2");
    }
}
