package com.basic.javaKang.Collections.collection;

import com.basic.javaKang.bean.Person;
import org.junit.Test;

import java.util.*;

/**
 * @Author: 23236
 * @createTime: 2022/2/21   13:35
 * @description: List ->ArrayList,LinkedList,Vector
 **/
public class ListTest {

    @Test
    public void test1(){
        Collection col= new ArrayList();
        col.add(123);
        col.add(123);
        col.add(456);
        col.add(new String("tom"));
        col.add(new Person("appandi",24));
        col.add(new Person("tom",24));
        col.add(new Person("jerry",24));
        col.add(true);
        Collection col1= Arrays.asList(123,456);

        System.out.println(col);
        System.out.println(col.contains(123));
        System.out.println(col.contains(new Person("appandi",24)));
        System.out.println(col.containsAll(col));
        List l1=new ArrayList();

        Person p=new Person("appandi",24);
        col.remove(p);
        col.retainAll(col1);        //retainAll求交期
        System.out.println(col);

        Iterator it =  col.iterator();
        for (int i = 0; i < col.size(); i++) {
            System.out.println(it.next());
        }

        Iterator it1 =  col1.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }

        System.out.println(new Person("nasirdin",22));
    }
}

