package com.basic.javaKang.thread;

/**
 * @author: 23236
 * @date: 2021/3/26 22:22
 * @description:
 */
public class ThreadTest {
    public static int count=0;
    public static void main(String[] args) {

        MyThread t1=new MyThread();
        t1.start();
        Thread t2=new MyThread();
        t2.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2!=0){
                        count++;
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最后:"+count);
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                ThreadTest.count++;
                System.out.print(Thread.currentThread().getName()+":"+i);
                System.out.print("----"+Thread.currentThread().getPriority());
                System.out.println();

            }
        }
    }
}
