package com.basic.javaKang.NewFeature;

import org.junit.Test;

import java.util.Comparator;

/**
 * @Author: 23236
 * @createTime: 2022/4/3   17:25
 * @description: lamda
 *
 * 学习的思维方式
 * 1.大处着眼，小处着手
 * 2.逆向思维，反证法
 * 3.透过问题看本质
 *
 * 1.小不忍则乱大谋
 * 2.识时务者为俊杰（多读一些，经济学，生活中的经济学）
 *
 **/
public class LamdaTest {

    @Test
    public void test1(){

        //多线程
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        run1.run();

        Runnable run2=()-> System.out.println("我爱中国");
        run2.run();

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator.compare(11, 12));
        //lamda表达式的用法
        Comparator<Integer> comparator1 =(o1,o2)-> Integer.compare(o1,o2);
        System.out.println(comparator1.compare(21, 12));
        //方法引用的用法
        Comparator<Integer> comparator2 =Integer::compare;
        System.out.println(comparator2.compare(21, 12));


    }

}
