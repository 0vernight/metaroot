package com.basic.javaKang.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 23236
 * @date: 2021/3/31 14:08
 * @description:
 *
 * 当用继承的方式实现了线程，为了锁的唯一性，ReentrantLock前面加上static 关键字
 *
 * 使用的优先顺序:
 * * Lock --->同步代码块（已经进入了方法体，分配了相应资源）---〉同步方法〈在方法体之外)
 */
class Window1 implements Runnable {
    private static int ticket = 100;

//    当extends Thread时下面的要加static
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                Thread.sleep(100);
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }


        }
    }
}

public class ReentrantLockTest{
    public static void main(String[] args) {

        Window1 w = new Window1();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}