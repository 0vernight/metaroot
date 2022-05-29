package com.basic.javaKang.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: 23236
 * @createTime: 2022/3/8   21:46
 * @description: 对应数据库当中的customer类
 *
 * lombok 可以学一学跟着mybatis
 *
 **/

@Data
public class Customer<T> extends Person<T> implements Serializable {
    public static final long serialVersionUID = 42544573757L;//每个序列化的类必须给出序列化的版本
    T type;
    public int customerId;
    public int storeId;
    public int active;
    public String firstName ;
    public String lastName ;
    public int age ;
    public String email;
    public int addressId;
    public String address;
    public String password;
    public Date createDate;
    public Date lastDate;

    public Customer() {
    }

    public Customer(T type, String firstName, String lastName, int age, String email) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    public Customer( String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    public Customer( String firstName, String lastName, int age, String email,String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address=address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "type=" + type +
                ", customerId=" + customerId +
                ", storeId=" + storeId +
                ", active=" + active +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", addressId='" + addressId + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", createDate='" + createDate + '\'' +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer<?> customer = (Customer<?>) o;
        return customerId == customer.customerId && storeId == customer.storeId && active == customer.active && age == customer.age && Objects.equals(type, customer.type) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(addressId, customer.addressId) && Objects.equals(address, customer.address) && Objects.equals(password, customer.password) && Objects.equals(createDate, customer.createDate) && Objects.equals(lastDate, customer.lastDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, customerId, storeId, active, firstName, lastName, age, email, addressId, address, password, createDate, lastDate);
    }
}
