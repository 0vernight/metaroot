package com.basic.javaKang.Generic;

import com.basic.javaKang.bean.Customer;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: 23236
 * @createTime: 2022/3/6   21:58
 * @description: jdk5.0之后新加的特性
 *
 * 泛型不能是基本的数据类型，必须是包装类
 *
 **/
public class GenericTest {

    @Test
    public void test01(){

        ArrayList list = new ArrayList();
//        存放成绩
        list.add(98);
        list.add(94);
        list.add(95);
        list.add(91);
        list.add(92);

//        中间可能参有其他类型的数据,所以当后续使用数据的时候可能会出现ClassCastException异常
        list.add("tom");
        System.out.println(list);
        for (Object sc : list) {
            int score= (Integer) sc;
            System.out.println(score);
        }
    }

    @Test
    public void test02(){
        ArrayList<Integer> li = new ArrayList<>();
        li.add(98);
        li.add(67);
        li.add(66);
        li.add(98);

        for (Integer s : li) {
            int score=s;
            System.out.println(score);
        }
    }


    @Test
    public void test03(){
        CustomerDAO dao0 = new CustomerDAO();
        dao0.add(new Customer());
    }
    @Test
    public  void  test04(){
        //通配符？
    }


}
