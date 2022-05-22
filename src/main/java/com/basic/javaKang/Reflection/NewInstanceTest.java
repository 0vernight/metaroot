package com.basic.javaKang.Reflection;

import com.basic.javaKang.bean.Person;
import org.junit.Test;


import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @Author: 23236
 * @createTime: 2022/3/27   18:16
 * @description: 通过反射创建对应的运行时类的对象
 *
 *
 **/
public class NewInstanceTest {

    @Test
    public void test01() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Person> clazz = Person.class;
        Person person = clazz.getDeclaredConstructor().newInstance();

        System.out.println(person);

    }

//    反射的动态性

    @Test
    public void test02() throws Exception {
        Class<?> aClass = Class.forName("src.main.java.mike.java.bean.Person");
        Object o = aClass.getDeclaredConstructor().newInstance();

        System.out.println(o);

        for (int i = 0; i < 100; i++) {
            int j = new Random().nextInt(3);
            String classPath="";

//            classPath="java.lang.Object";
            switch (j) {
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="mike.java.bean.Person";
                    break;
                default:
                    classPath="mike.java.bean.Student";
                    break;

            }
            try {
//                System.out.println(classPath);
                Object instance = getInstance(classPath);

                System.out.println(instance);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
//
//    此方法创建一个指定类的对象
//    classPath：指定类的全类名
    public Object getInstance(String classPath) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(classPath);
        Object o = aClass.getDeclaredConstructor().newInstance();
        return o;
    }






}
