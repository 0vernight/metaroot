package com.basic.javaKang.api;

import org.junit.Test;

/**
 * @author: 23236
 * @date: 2021/6/8 15:27
 * @description: stringbuffer与stringBuilder的区别
 * stringBuffer：
 * stringBuilder：
 */


public class StringBufferBuilderTest {
//    String stringBuffer StringBuilder三者的异同？
    /*
    String：不可变的字符串，底层用byte[]存储
    StringBuffer:线程安全效率低下，可变的字符序列，
    StringBuilder:线程不安全，可变的字符序列，
    StringBuffer的常用方法:(StringBuilder的方法差不多)
    stringBuffer append(xxx):提供了很多的append()方法，用于进行字符串拼接
    stringBuffer delete(int start,int end):删除指定位置的内容
    stringBuffer replace(int start, int end,String str):把[start, end)位置替换为
    strStringBuffer insert(int offset， xxx):在指定位置插入xxX
    StringBuffer reverse(:把当前字符序列逆转
    public int indexof (String str)
    public string substring(int start,int end)public int Length()
    public char charAt(int n )
    public void setcharAt(int n ,char ch)


    总结：
    增：append()
    删：delete()
    改：setCharAt()
    查：charAt()
    长度：length()
    *遍历：for+charAt()/toString()
    没有说明线程问题，一般都用StringBuilder()
    三者的效率为：StringBuilder()>StringBuffer()>String()
    */

    @Test
    public void sBuffer(){
        StringBuffer b1=new StringBuffer();
        StringBuffer b2=new StringBuffer("abc");


        System.out.println(b1.length());
        System.out.println(b2.length()<<1);
        StringBuilder s3=new StringBuilder("cde");
        System.out.println(s3.length());
    }
}

