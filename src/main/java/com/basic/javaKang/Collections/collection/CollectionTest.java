package com.basic.javaKang.Collections.collection;

import org.junit.Test;

import java.util.*;

/**
 * @Author: 23236
 * @createTime: 2021/10/15   21:33
 * @description: 1.集合框架的概述
 * 二、集合框架
 * /----collection接口:单列集合，用来存储一个一个的对象
 * /----List接口:存储有序的、可重复的数据。-->“动态”数组
 * /----Arraylist、 LinkedList、 Vector
 * /----Set接口:存储无序的、不可重复的数据-->高中讲的"集合”
 * / ----HashSet、 LinkedHashSet、 TreeSet
 * /----Map接口:双列集合，用来存储一对(key - value)一对的数据―-->高中函数: y = f(x)
 * /----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 **/
public class CollectionTest {
    //collection 接口的抽象方法很重要。
    //alt+enter

    @Test
    public  void collectionAbstractMathod(){
        Collection cl=new ArrayList();
        cl.add("mike");
        cl.add(25);
        cl.add(new Date());

        System.out.println(cl.size());
        System.out.println(cl.isEmpty());
        cl.clear();
        System.out.println(cl.size());
        System.out.println(cl.isEmpty());
        Collection col=new ArrayList();
        col.add("mai");

        cl.addAll(col);
        System.out.println(cl);
        List<String> list = Arrays.asList(new String[]{"mike", "mai", "darya", "ay"});
        System.out.println(list);
//        cl.retainAll()//计算两个集合的交集的
        //hashcode()
        //toArray()
        //contains()
        //containsall()
        //equals()
        //toArray()
        // remove()
        //removeall()
        //retainall()
        //

        //集合转换为-》数组toArray()
        //数组转换为-》集合 asList()

        col.add("java");
        col.add("c#");
        col.add(234);
        col.forEach(System.out::println );
    }
}
