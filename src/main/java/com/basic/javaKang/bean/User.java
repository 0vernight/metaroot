package com.basic.javaKang.bean;

import java.util.Objects;

/**
 * @Author: 23236
 * @createTime: 2022/3/7   13:18
 * @description: alot of users are person
 **/
public class User<T> extends Person<T>{
    public T type;
    private String name ;
    private int age ;
    private String password;
    private String img;
    private String email;
    private String address;

    public User() {
        this.name = "name=deafult";
        this.age = 18;
    }
    private User(String name) {
        this.name = name;
        this.age = 18;
    }

    public User(T type, String name, int age, String email, String address) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public User(String name, T type, String name1, int age, String email, String address) {
        super(name);
        this.type = type;
        this.name = name1;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public User(String name, int age, T type, String name1, int age1, String email, String address) {
        super(name, age);
        this.type = type;
        this.name = name1;
        this.age = age1;
        this.email = email;
        this.address = address;
    }

    public User(int age, String name, T type, T type1, String name1, int age1, String email, String address) {
        super(age, name, type);
        this.type = type1;
        this.name = name1;
        this.age = age1;
        this.email = email;
        this.address = address;
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User<?> user = (User<?>) o;
        return age == user.age && Objects.equals(type, user.type) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, name, age, email, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public T getType() {
        return type;
    }

    @Override
    public void setType(T type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
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
