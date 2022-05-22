package com.basic.javaKang.thread;

/**
 * @author: 23236
 * @date: 2021/3/30 20:19
 * @description:
 *
 * 锁有两种方式
 * 要确保监视器及锁的唯一性
 * 同步代码块synchronized(Windows.class) {
 *     需要被同步的代码
 * }
 *
 * 同步方法
 *
 *
 * Class a=Windows.class;类也是一个对象
 */
class Windows implements Runnable{
    private int ticket=100;
    private String name;
    @Override
    public void run() {
        while (true){
            synchronized(Windows.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowRunable{
    public static void main(String[] args) {
        Windows w = new Windows();
//        Class a=Windows.class;


        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.start();
        t2.start();
        t3.start();

    }
}
