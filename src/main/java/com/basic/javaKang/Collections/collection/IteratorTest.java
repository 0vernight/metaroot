package com.basic.javaKang.Collections.collection;

import com.basic.javaKang.bean.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: 23236
 * @createTime: 2022/2/21   22:55
 * @description: iterator important and must practice very well
 *
 **/
public class IteratorTest {
    @Test
    public  void test1(){
        Collection coll= new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(456);
        coll.add(new String("tom"));
        coll.add(new Person("appandi",24));
        coll.add(new Person("tom",24));
        coll.add(new Person("jerry",24));
        coll.add(true);

        Iterator it= coll.iterator();

        while (it.hasNext()){
            Object obj=it.next();
            if ("tom".equals(obj)){
                it.remove();
            }
        }
        Iterator it1 = coll.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        coll.add("mini ipad");

        for (Object o :
                coll) {
            System.out.println(o);
        }

        
    }
}
