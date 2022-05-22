package com.basic.javaKang.thread;

/**
 * @author: 23236
 * @date: 2021/3/31 16:25
 * @description:使用两个线程打印1-100。线程1,线程2交替打印
 *
 * notify();唤醒被阻塞的线程
 * wait()会释放锁sleep()不会释放锁
 *
 *
 * 涉及到的三个方法:
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的。
 * notifyALl():一旦执行此方法，就会唤醒所有被wait的线程。
 * 说明:
 * 1.wait()， notify( )，notifyALL()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAlL()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *      否则，会出现ILLegaLMonitorStateException异常。
 * 3.wait(),notify()，notifyALl()三个方法是定义在java.Lang.object类中。
 *
 *
 * 面试题: sLeep()和wait()的异同?
 * 1.相同点:一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点:1）两个方法声明的位置不同:Thread类中声明sleep() , object类中声明wait()*
 *         2）调用的要求不同: sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 *         3）关于是否释放同步监视器:如果两个方法都使用在同步代码块或同步方法中，sleep()不会
 * 泽放锁，wait()会释放锁。
 */
class Number implements Runnable{

    private int num=1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num<=100){
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                    try {
                        wait();         //当前线程暂停，释放锁。调用此方法者为synchronized的监视器一样的类
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}

public class Communication {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1=new Thread(number);
        Thread t2=new Thread(number);
        t1.setName("A线程");
        t2.setName("B线程");
        t1.start();
        t2.start();


    }
}
