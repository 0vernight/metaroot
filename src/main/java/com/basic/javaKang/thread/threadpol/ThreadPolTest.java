package com.basic.javaKang.thread.threadpol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 23236
 * @date: 2021/4/1 16:06
 * @description:
 * 创建多线程有几种方式?四种!
 * ExecutorService:真正的线程池接口。常见子类ThreadPoolExecutor
 * void execute(Runnable command):执行任务/命令，没有返回值，一般用来执行
 * Runnable
 * ><T> Future<T> submit(Callable<T> task):执行任务，有返回值，一般又来执行
 * Callable
 * >void shutdown():关闭连接池
 * Executors:工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 * Executors.newCachedThreadPool():创建一个可根据需要创建新线程的线程池
 * Executors.newFixedThreadPool(n);创建一个可重用固定线程数的线程池I
 * Executors.newSingleThreadExecutor():创建一个只有一个线程的线程池
 * Executors.newScheduledThreadPool(n):创建一个线程池，它可安排在给定延迟后运
 * 行命令或者定期地执行。
 * 创建多线程有几种方式?四种!
 */

class NumTread implements Runnable {

    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class OddNumTread implements Runnable {

    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPolTest {
    public static void main(String[] args) {
        NumTread numTread = new NumTread();
        OddNumTread oddNumTread = new OddNumTread();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        System.out.println(executorService.getClass());


//        设置线程池必须在ThreadPoolExecutors类中实现
//        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
//        tpe.setCorePoolSize(3);
//        tpe.setKeepAliveTime();

//        可以设置有返回值的callable的实现类的传入
//        executorService.subt()      //适用于Callablemi

        executorService.execute(numTread);  //适用于Runable
        executorService.execute(oddNumTread);  //适用于Runable

        executorService.shutdown();
    }
}
