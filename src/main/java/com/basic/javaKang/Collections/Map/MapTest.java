package com.basic.javaKang.Collections.Map;

import org.junit.Test;

import java.util.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/1   21:28
 * @description: importan data table such as collection
 *
 * hashmap 主要实现类，线程不安全效率高，
 * hashtable线程安全，效率低
 **/
public class MapTest {

    @Test
    public void test03(){
//        遍历map
//        set keyset()  collection valuse() set entry()
        Map<Object, Object> map = new HashMap<>();
        map.put("name","mike");
        map.put("age",24);
        map.put("tel","1234556");
        System.out.println(map);
        Object k;
//        遍历key/**/
        Set<Object> keySet =map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            k=iterator.next();
            System.out.print("keyName="+k);
            System.out.println("    values="+map.get(k));
        }
//        遍历values
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.println(value);
            System.out.println(value);
        }
        Iterator<Object> iterator2 = values.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

//        遍历所有的key-values
//        entrySet();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator1 = entries.iterator();
        for (Map.Entry en:entries) {
            System.out.println("key="+en.getKey()+" value="+en.getValue());
        }
        while (iterator1.hasNext()){
            Map.Entry entry = iterator1.next();
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());

        }

    }

    @Test
    public void test02(){
//        添加，删除，修改

    }


    @Test
    public void test01(){
        Map map=new HashMap();

        //hashmap可以保存Null,hashtable中key和val只有一个是空的就放不进去。
        map.put(null,123);
        map.put(null,234);
        System.out.println(map);
//        map=new Hashtable();
//        map.put(null,456);
//        System.out.println(map);

//        TreeMap是按照key来排序的
//        Properties其key和value都是string类型



    }

}
