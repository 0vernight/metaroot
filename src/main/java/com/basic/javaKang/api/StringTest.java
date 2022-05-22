package com.basic.javaKang.api;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: 23236
 * @date: 2021/6/3 15:32
 * @description:
 *
 *
 */


public class StringTest {

    /*
    * string类与其他结构之间的转换
    *1.string-->基本数据类型：调用包装类的parseXXX()方法
    *2.其他类型-->string 调用valueOf()
    *3.string--char[]之间的转换 s2.toCharArray();
    *4.string--byte[]之间的转换 new String(arr);//调用构造器
    *
    * */
    @Test
    public void stringChange(){
        String s1="123";
        int n1=Integer.parseInt(s1);
        System.out.println(++n1);

//        String-->char[]
        String s2="haah123";
        char[] chars = s2.toCharArray();
        System.out.println(chars[5]);

//        char[]-->String
        char[] arr = {'h', 'a', 'h', 'a'};
        String s = new String(arr);

//        String -->byte[]编码过程
        byte[] bytes = s2.getBytes();
//        System.out.println(s2.getBytes("gbk"));//抛异常
//        System.out.println(bytes.length);
        System.out.println(bytes[1]);
        System.out.println(Arrays.toString(bytes));
//        byte[] -->String解码过程  调用string的构造器
        String s3 = new String(bytes);
        System.out.println(s3);

    }
    /*
    *
    * replace,split,matches
    * */
    @Test
    public void StringMathod(){
        String s1=" hello World ";
        System.out.println(s1.length());
        System.out.println(s1.charAt(6));
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.trim());
        System.out.println(s1.isEmpty());
        System.out.println(s1.concat("mai"));
        System.out.println(s1.compareTo("hello z"));
        System.out.println(s1.substring(2, 8));
        System.out.println(s1.startsWith(" h"));
        System.out.println(s1.contains("llo"));
        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.lastIndexOf("lo"));

    }

    /*
    * 两种方式创建string
    *   1字面量定义的方式
    *   2new+构造函数的方式
    * 搞清楚两种方式在内存当中的分配
    *
    * 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    * 只要其中有一个是变量，结果就在堆中
    * 如果拼接的结果调用intern()方法，返回值就在常量池中
    * */
    @Test
    public void StringAssignment(){
        //数据保存在方法区中的字符串常量池当中
        String s1="java";
        String s2="java";

//        数据保存在堆当中
        String s3=new String("java");
        String s4=new String("java");

        String s5="ee";
        String st1="javaee";
        String st2="java"+"ee";//false
        String st3=s1+"ee";//false
        String st4="java"+s5;//fale
        String st5=s1+s5;//false
        String st6=st5.intern();//true 返回的是常量池中的值

        System.out.println(st1 == st2);
        System.out.println(st1 == st3);
        System.out.println(st1 == st4);
        System.out.println(st3 == st4);
        System.out.println(st1 == st5);
        System.out.println(st1 == st6);
        //字面量的链接在常量池中完成，而其他的变量参与了在堆中完成
        //结论：常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。只要其中有一个是变量，结果就在堆中
        //如果拼接的结果调用intern()方法，返回值就在常量池中


    }

/*
 * string:字符串，使用一对""引起来表示。
 * 1.String声明为final的，不可被继承
 * 2.String实现了Serializable接口:表示字符串是支持序列化的。
 * 实现了ComparabLe接口:表示String可以比较大小
 * 3.String内部定义了final char[ ] value用于存储字符串数据,现在是byte[]了
 * 4.String:代表不可变的字符序列。简称:不可变性。
 *      体现:1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
 *          2．当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能不能使用原有的value进行赋值
 *          3.当调用String的repLace()方法修改指定字符或字符串时，，也需要重新指定内存区域赋值，不能不能使用原有的value进行赋值
 * 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
 * 6.字符串常量池中是不会存储相同内容的字符串的。
 */
    @Test
    public void test1(){
        String s1="abc";//字面量定义，没有new出来
        String s2="abc";
        System.out.println(s1 == s2);
    }


}
