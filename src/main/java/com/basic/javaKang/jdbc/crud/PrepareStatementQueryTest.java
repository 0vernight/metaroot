package com.basic.javaKang.jdbc.crud;

import com.basic.javaKang.bean.Customer;
import com.basic.javaKang.bean.Person;
import com.basic.javaKang.bean.Student;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/5/24   21:45
 * @description: 不同的表之间的查询
 *
 * preparestatement 好处如下：
 * 1.能避免SQL注入问题
 * 2.可以操作Blob数据类型
 * 3.可以实现更高效的的批量操作。（比起statement只需要校验一次）
 *
 **/
public class PrepareStatementQueryTest {


    @Test
    public  void commonTableQuery(){

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


    //泛型方法之前必须指明泛型类型
    public  <T> List<T>  queryList(Class <T> clazz,String sql, Object... args) {

        ArrayList<T> types = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            types = new ArrayList<T>();

            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.prepare sql return preparestatement
//            sql = "select first_name,last_name,email from customer where customer_id=?";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);

            }
            //3.execute & return result
            resultSet = preparedStatement.executeQuery();

            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                //Customer<Person> cust = new Customer<>();
                //不确定是那个表的，用泛型
                T t=clazz.getDeclaredConstructor().newInstance();
                //处理结果集当中的每一行数据
                for (int i = 0; i < columnCount; i++) {
                    //获取某一列的值
                    Object custValue = resultSet.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给cust对象的columnName 赋值为custValue通过反射来实现
                    Field field = clazz.getDeclaredField(columnName);
                    //如果不设置下面的语句将不能访问该泛型下的私有属性
                    //cannot access a member of class com.basic.javaKang.bean.Student with modifiers "private"
                    field.setAccessible(true);
                    field.set(t, custValue);

                }

                //                String firstName = resultSet.getString(1);
                //                String lastNmae = resultSet.getString(2);
                //                String email = resultSet.getString(3);
                //
                //                //将数据封装成对象
                //                Customer<Person> customer = new Customer<>(firstName, lastNmae, 18, email);
                //                System.out.println(customer);
                //                customers.add(customer);
                types.add(t);
            }
            //正常结束就返回正常的值
            return types;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //close resources
            //5.closeResource
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }
        //如果出现了异常的话就返回空
        return null;

    }

}
