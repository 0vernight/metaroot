package com.basic.javaKang.Collections.Map;

import com.basic.javaKang.bean.Person;
import org.junit.Test;

import java.util.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/5   14:58
 * @description: 要求key必须是由同一个类创建的对象
 **/
public class TreeMapTest {

    @Test
    public void test01(){
//        向treemap中添加key-value 时要求key必须是由同一个类创建的对象
//
//
//        因为要根据key 来进行排序，自然排序（Comparable)，定制排序（Comparator)

        TreeMap treeMap = new TreeMap();
        treeMap.put("name","mike");
        treeMap.put("age",24);
        treeMap.put("tel","1234556");
        treeMap.put("version",1.0);
        System.out.println(treeMap);

    }
    @Test
    public void test02(){
        //按照姓名从大到小，年龄从小到大
//        自然排序，需要key类实现comparable接口
        TreeMap treeMap = new TreeMap();
        Person p1=new Person("tom",21);
        Person p2=new Person("tom2",22);
        Person p3=new Person("tom3",23);
        Person p4=new Person("tom4",24);
        treeMap.put(p1,95);
        treeMap.put(p2,96);
        treeMap.put(p3,97);
        treeMap.put(p4,98);

        Set set = treeMap.entrySet();
//        for (Object o : set) {
//            Map.Entry entry = (Map.Entry) o;
//            System.out.println("key="+entry.getKey()+"  value="+entry.getValue());
//        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key="+entry.getKey()+"  value="+entry.getValue());

        }


    }
    @Test
    public void test03(){
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person&& o2 instanceof Person){
                    Person person1 = (Person) o1;
                    Person person2 = (Person) o2;
                    return -Integer.compare(person1.getAge(),person2.getAge());

                }
                throw new RuntimeException("类型不匹配");
            }
        });
        Person p1=new Person("tommy",21);
        Person p2=new Person("jerry",22);
        Person p3=new Person("rows",23);
        Person p4=new Person("darya",24);
        treeMap.put(p1,95);
        treeMap.put(p2,96);
        treeMap.put(p3,97);
        treeMap.put(p4,98);

        Set set = treeMap.entrySet();
        System.out.println(treeMap);
        for (Object o : set) {
            Map.Entry entry=(Map.Entry)o;
            System.out.println("key="+entry.getKey()+"value="+entry.getValue());
        }
    }
}
