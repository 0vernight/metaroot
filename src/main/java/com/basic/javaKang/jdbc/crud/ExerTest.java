package com.basic.javaKang.jdbc.crud;

import com.basic.javaKang.bean.Customer;
import com.basic.javaKang.bean.Person;
import com.basic.javaKang.bean.Student;
import com.basic.javaKang.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 23236
 * @createTime: 2022/5/25   20:20
 * @description: jdbc的联系
 **/
public class ExerTest {

    public static void main(String[] args) {
        updateTest();
    }
    @Test
    public static void updateTest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name =scanner.next();

        System.out.println("请输入学生年龄：");
        int age =scanner.nextInt();

        System.out.println("请输入学生邮箱：");
        String email =scanner.next();

        System.out.println("请输入学生住址：");
        String address =scanner.next();

        System.out.println("请输入学生班级：");
        String cid =scanner.next();

        Student<Object> student = new Student<>("mike");
        String sql="insert into student (name,age,student_email,student_address,student_class) values(?,?,?,?,?)";
        updateCommon(Student.class,sql,name,age,email,address,cid);

        sql="update  student set name=?,age=?,student_email=?,student_address=? where student_id=?";
        updateCommon(Student.class,sql,"apandi",26,"34468@qq.com","22",1);
        //想要查数据库里的数据为空的数据时传递的参数？？？




    }


    //add student data for student data table
    //other alter or update just like insert but different sql
    public static <T> boolean updateCommon(Class<T> clazz,String sql ,Object ...args){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //true if the first result is a ResultSet object;
            //false if the first result is an update count or there is no result
            //意思就是：
            //当查询时true,当增删改时fasle
            //所以一般使用
//            if (preparedStatement.execute()) {
//                System.out.println("great the operation are success!");
//            }
            //影响到的数据数量
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }

    }

    //query data table for all tables
    @Test
    public void  queryTest(){

        String sql = "select first_name firstName ,last_name lastName,customer_id customerId, "
                +" age,email ,address_id addressId from customer where customer_id<?";
        Person<Customer> customer = new Customer<>();

        List ts = queryList(Customer.class,sql, 4);
        System.out.println(ts);

        sql = "select name ,age,student_email email, "
                +" student_address address from student where student_id<?";
        ts = queryList(Student.class,sql, 5);
        System.out.println(ts);

        //lamda
        ts.forEach(System.out::println);
    }


    //1.表级通用的查询
    public  <T> List<T> queryList(Class<T> clazz,String sql,Object ...args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;//result set get one row info
        try {
            List<T> list=new ArrayList<>();
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
//        DatabaseMetaData metaData = connection.getMetaData();
            resultSet = preparedStatement.executeQuery();
//        ResultSetMetaData metaData1 = preparedStatement.getMetaData();//
            ResultSetMetaData metaData2 = resultSet.getMetaData();
            int count =metaData2.getColumnCount();
            //beginning set one row data to one new t object
            while (resultSet.next()) {
                T t=clazz.getDeclaredConstructor().newInstance();
                //set one column values
                for (int i = 0; i < count; i++) {
                    String columnName=metaData2.getColumnLabel(i+1);
                    Object columnValue = resultSet.getObject(i+1);
                    Field field = t.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        //return null;
    }
    //2.表级通用的更改
}
