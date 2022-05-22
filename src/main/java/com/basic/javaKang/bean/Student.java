package com.basic.javaKang.bean;

import java.io.Serializable;

/**
 * @Author: 23236
 * @createTime: 2022/3/14   20:41
 * @description: 对象流，序列化时用的类
 **/
public class Student<T> implements Serializable {
    public static final long serialVersionUID = 42544573737L;//每个序列化的类必须给出序列化的版本
    T type;
    private String name ;
    private int age ;
    private String email;
    private String address;
    private String password;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }
    private String show(String name) {
        this.name = name;
        System.out.println("student class out puts!="+this.name);
        return "name="+this.name;
    }

    public Student(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
