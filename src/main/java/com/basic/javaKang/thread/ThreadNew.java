package com.basic.javaKang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: 23236
 * @date: 2021/4/1 15:31
 * @description:
 */

class NumTread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NumTread numTread = new NumTread();
        FutureTask futureTask = new FutureTask(numTread);
        Thread thread = new Thread(futureTask);
        thread.setName("callable");
        thread.start();

        try {
            Object o = futureTask.get();
            System.out.println("总和为:"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
