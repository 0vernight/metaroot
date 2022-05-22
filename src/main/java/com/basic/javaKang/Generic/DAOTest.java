package com.basic.javaKang.Generic;

import com.basic.javaKang.bean.User;

import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/3/9   23:14
 * @description: test for dao
 **/
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao1 = new DAO<>();
        //dao里面的map必须是创建实例化的要不然报空指针异常，NullPointerException
        dao1.save("1001",new User("mike",23));
        dao1.save("1002",new User("麦",24));
        dao1.save("1003",new User("mi来ke",25));

        List<User> list = dao1.list();
        System.out.println(list);
        list.forEach(System.out::println);
//        System.out.println(dao1);
    }
}
