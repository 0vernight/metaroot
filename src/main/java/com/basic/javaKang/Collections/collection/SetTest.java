package com.basic.javaKang.Collections.collection;

import com.basic.javaKang.bean.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 23236
 * @createTime: 2022/2/27   17:48
 * @description: 无序，不重复的集合
 * 没有的定义额外的接口
 **/
public class SetTest {

    @Test
    public void Test01(){

        //无序无重复
        Set set=new HashSet();
        set.add(123);
        set.add(123);
        set.add(345);
        set.add(456);
        set.add(new Person("jerey",22));
        set.add("aaaa");
        set.add("tom");
//        System.out.println(set);

        //
        Set set1=new HashSet();
        Person tom = new Person("tom",22);
        Person jerry = new Person("jerry",22);
        set1.add(tom);
        set1.add(jerry);
        System.out.println(set1);

        tom.setName("tommy");
        set1.remove(tom);       //删除是他要拿着tom去计算hashcode值，其实其hashcode 已经变了，所以remove没有成功，不会把改变后的tommy删掉。
        System.out.println(set1);

        set1.add(new Person("tommy",22));//还能加进去
        set1.add(new Person("tom",22));//还能加进去
        System.out.println(set1);



    }
}
