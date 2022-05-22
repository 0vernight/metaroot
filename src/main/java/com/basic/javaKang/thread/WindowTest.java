package com.basic.javaKang.thread;

/**
 * @author: 23236
 * @date: 2021/3/27 10:02
 * @description:
 */
public class WindowTest {
    public static void main(String[] args) {
        Window t1=new Window();
        Window t2=new Window();
        Window t3=new Window();
        t1.start();
        t2.start();
        t3.start();
    }
}
