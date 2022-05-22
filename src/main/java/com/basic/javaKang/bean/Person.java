package com.basic.javaKang.bean;

import java.util.Objects;

/**
 * @Author: 23236
 * @createTime: 2022/2/21   13:43
 * @description: person
 **/
public class Person<T> implements Comparable<Person>{ //Comparable里的泛型写的是我们要比较的东西的类名
    private int age;
    private String name;
    public String address;
    T type;

    public Person() {
        super();
        this.age=18;
        this.name="mike";
    }

    public Person(String name) {
        this.name = name;
        this.age=18;    //永远十八岁
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age, String name, T type) {
        this.age = age;
        this.name = name;
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person<?> person = (Person<?>) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(type, person.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, type);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int res = -this.name.compareTo(o.name);
        if (res != 0) {        //就是说两个值是一样的结果只是0
            return res;
        } else {
            return Integer.compare(this.age, o.age);
        }
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age, name);
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Person){
//            Person p1=(Person) o;
////            return Integer.compare(p1.getAge(),p2.getAge());
////            return Integer.compare(this.age, p1.age);//比较两个int要用compare
////            return -this.name.compareTo(p1.name);//如果从大到小排序this前面加-
//            int res=-this.name.compareTo(p1.name);
//            if (res!=0){        //就是说两个值是一样的结果只是0
//                return res;
//            }else {
//                return Integer.compare(this.age,p1.age);
//            }
//        }else {
//            throw new RuntimeException("输入的数据类型不匹配");
//        }
//    }
}
