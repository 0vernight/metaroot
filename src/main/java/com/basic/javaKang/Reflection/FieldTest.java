package com.basic.javaKang.Reflection;

import com.basic.javaKang.bean.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author: 23236
 * @createTime: 2022/3/27   20:22
 * @description: getFields和getDeclaredFields的区别 。
 * 反射中getFields 和getDeclaredFields之间的的区别是:
 * 前者按照权限获取public的自己和父类的所有声明的属性。
 * 后者获取当前类中所有的属性不包含父类。
 **/
public class FieldTest {

    @Test
    public void test01(){
//        反射中getFields 和getDeclaredFields之间的的区别是:
//        前者按照权限获取public的自己和父类的所有声明的属性。
//        后者获取当前类中所有的属性不包含父类。

        Class<User> UserClass = User.class;
        Field[] fields = UserClass.getFields();
        for (Field field : fields) {
            //            1.权限修饰符
            System.out.println(Modifier.toString(field.getModifiers()));
//            2.数据类型
            System.out.println(field.getType());
//            3.变量名
            System.out.println(field.getName());
        }
        System.out.println();
        Field[] declaredFields = UserClass.getDeclaredFields();
        for (Field field : declaredFields) {
//            1.权限修饰符
            System.out.print(Modifier.toString(field.getModifiers())+"\t");
//            2.数据类型
            System.out.print(field.getType().getName()+"\t");
//            3.变量名
            System.out.print(field.getName()+"\t");
//            4.注解
            System.out.println(field.getAnnotations().toString());
        }
    }
}
