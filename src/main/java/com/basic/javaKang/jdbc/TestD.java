package com.basic.javaKang.jdbc;


import java.util.Random;

/***
 *
 * 测试数据库链接
 * 艾克演示
 * mysql & oracle 分别是Jdbc的继承类
 *
 *在22年五月19日在浙江泊雅酒店学习小康老师的jdbc课程时补充了与本地数据库的链接
 *
 */

public class TestD {
    public static void main(String[] args) throws Exception {

//        String str1="hello";
//        String str2=new String("hello");
//        String str3="he"+"llo";
//        String str4=String.valueOf("hello");
//        Integer a=new Integer(127);
//        Integer b=new Integer(128);
////        float f=12.3;
        if (false&&false)
            System.out.println("false");

        if (1 == 1) {
            JDBC mysql=new Mysql();
            Mysql mysql1=new Mysql();
            method(mysql);
//            //mysql1.sellect(2);
            JDBC jdbc = new JDBC();
            method(jdbc);

        }else if (1==-1){
            JDBC orale=new Orale();
            method(orale);
        }
        Random random=new Random();

        System.out.println("main函数结束");
        System.out.println("mian结束了");
    }

    public static void method(JDBC db) throws Exception {
        db.connect();
        //db.sellect();

    }
}
