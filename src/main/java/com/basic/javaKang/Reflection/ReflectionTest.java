package com.basic.javaKang.Reflection;

import com.basic.javaKang.bean.Person;
import com.basic.javaKang.bean.Student;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author: 23236
 * @createTime: 2022/3/20   21:39
 * @description: 反射机制
 *
 * 可以有Class 对象的有；
 *  1.所有的class，内部类，外部类，静态，匿名类等）
 *  2.interface接口
 *  3.[]数组
 *  4.enum数组
 *  5.annotation注解@interface
 *  6.primitive type基本数据类型
 *  7.void万能类
 *
 *  java -c -->java .exe
 *
 *
 **/
public class ReflectionTest {
    //反射之前是不能调用类的私有方法和属性的

    //反射
    @Test
    public void test01() throws Exception{
        //反射机制
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class,int.class);//构造器的参数类型要提前声明好
        Person mike = constructor.newInstance("mike", 19);


        System.out.println(mike);


    }

    @Test
    public void test02() throws Exception {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getConstructor();
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class);
        Student mike = constructor.newInstance();
        Field password = studentClass.getDeclaredField("password");
        System.out.println(mike);
        password.setAccessible(true);
        password.set(mike,"shanggui");
        System.out.println(mike);

        Method show = studentClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object res = show.invoke(mike, "新疆");
        System.out.println(res);

//        //反射机制和对象中的封装性是否矛盾的？
//        直接new 和反射的方式都可以调用公共的结构，开发中什么时候使用什么技术？
//        反射的特征：动态性
//
         /*

        万事万物皆对象
        */
    }

    //获取Class类的实例方式
    //大的Class 实列对应着一个运行类
    @Test
    public void test03() throws ClassNotFoundException {
//        方法一
        Class<Person> personClass = Person.class;
//        方法二
        Person<Object> p = new Person<>();
        Class<? extends Person> aClass = p.getClass();
//        方法三：最能体现动态性，使用频率最高
        //"BasicJava.src.mike.java.bean.Person"  使用repository路径找不到，且必须使用点不能使用斜杠来获取文件地址
        Class<?> aClass1 = Class.forName("src.main.java.mike.java.bean.Person");

        System.out.println(personClass);
        System.out.println(aClass);
        System.out.println(aClass1);
        System.out.println(personClass == aClass);
        System.out.println(aClass == aClass1);
        //获取的方式不一样的获取的都是同一个实列
//        方法四：使用class loader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("src.main.java.mike.java.bean.Person");
        System.out.println(aClass2);
        System.out.println(aClass == aClass1);

    }

    @Test
    public void test04() throws  Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
//        读取配置文件的方式一.文件位置放在了module下（src外，可以通过"src//jdbc.properties"来访问src下的）
//        加载map的properties类的加载器
        properties.load(fis);


        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name="+name+"password="+password);

//        读取配置文件方式二文件放在了src下（mode里的src下）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);

        String name1 = properties.getProperty("name");
        String password1 = properties.getProperty("password");
        System.out.println("name="+name1+"password="+password1);



    }
}
