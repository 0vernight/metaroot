package com.basic.javaKang.Collections.collection;

import com.basic.javaKang.bean.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: 23236
 * @createTime: 2022/2/27   22:55
 * @description: TreeSet
 **/
public class TreeSetTest {

    @Test
    public void test01(){
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(-22);
        treeSet.add(34);
        treeSet.add(23);
        treeSet.add(-23);
        treeSet.add(23);
        treeSet.add(-12);
        System.out.println(treeSet);

        TreeSet set1=new TreeSet();
        set1.add(new Person("tom1",28));
        set1.add(new Person("tom2",24));
        set1.add(new Person("tom3",20));
        set1.add(new Person("tom4",26));
        set1.add(new Person("tom5",25));

        System.out.println(set1);
    }

    @Test
    public void test02(){

        //定制排序
        Comparator comp=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person&&o2 instanceof Person){
                    Person p1=(Person) o1;
                    Person p2=(Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set1=new TreeSet(comp);
        set1.add(new Person("tom",28));
        set1.add(new Person("tom",24));
        set1.add(new Person("tom",20));
        set1.add(new Person("tom",26));
        set1.add(new Person("tom",25));

        System.out.println(set1);
    }
}
