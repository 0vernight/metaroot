package com.basic.javaKang.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/3/6   10:46
 * @description: 操作collection的工具类，类似操作数组的Arrays
 **/
public class CollectionsTest {
//
//    常用的方法，
//      reverse(),shuffle(),swap(),sort(),max(),min(),frequency()返回指定元素出现的频率,replaceall(),
//      copy()
//
    @Test
    public void test01(){
        List list=new ArrayList();
        list.add(123);
        list.add(0);
        list.add(-23);
        list.add(23);
        list.add(98);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

//        错误：使用copy时不能直接复制,得先造好数组的长度，初始化长度，不是数组实际的长度
//        ArrayList dest=new ArrayList(list.size()); //复制的目标数组
//        System.out.println(dest.size());
//        Collections.copy(dest,list);
//        System.out.println(dest);
//        正确：
        List dest=Arrays.asList(new Object[list.size()]); //复制的目标数组
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);

    }


}
