package com.basic.javaKang.thread;

/**
 * @author: 23236
 * @date: 2021/3/27 9:59
 * @description:
 */
class Window extends Thread{
    private static int ticket=100;

    private Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
