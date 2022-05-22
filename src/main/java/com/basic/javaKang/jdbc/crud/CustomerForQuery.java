package com.basic.javaKang.jdbc.crud;

import com.basic.javaKang.bean.Customer;
import com.basic.javaKang.bean.Person;
import org.junit.Test;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/5/21   22:02
 * @description: 查询比起其他三个来说更为复杂而且更为频繁
 **/
public class CustomerForQuery {


    @Test
    public void queryCustomerTest(){
        String sql = "select first_name firstName ,last_name lastName,customer_id customerId, "
        +" age,email ,address_id addressId from customer where customer_id=?";
        List<Customer> customers = queryCustomer(sql, 2);
        System.out.println(customers);
    }


    //根据某一个表通用的查询
    public List<Customer> queryCustomer(String sql, Object... args) {

        ArrayList<Customer> customers = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            customers = new ArrayList<>();

            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.prepare sql return preparestatement
//            sql = "select first_name,last_name,email from customer where customer_id=?";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(1, args[i]);

            }
            //3.execute & return result
            resultSet = preparedStatement.executeQuery();

            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Customer<Person> cust = new Customer<>();
                //处理结果集当中的每一行数据
                for (int i = 0; i < columnCount; i++) {
                    //获取某一列的值
                    Object custValue = resultSet.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给cust对象的columnName 赋值为custValue通过反射来实现
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.set(cust, custValue);

                }

    //                String firstName = resultSet.getString(1);
    //                String lastNmae = resultSet.getString(2);
    //                String email = resultSet.getString(3);
    //
    //                //将数据封装成对象
    //                Customer<Person> customer = new Customer<>(firstName, lastNmae, 18, email);
    //                System.out.println(customer);
    //                customers.add(customer);
                    customers.add(cust);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            //close resources
            //5.closeResource
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }
        return customers;

    }

    @Test
    public void testQuery1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.prepare sql return preparestatement
            String sql = "select first_name,last_name,email from customer where customer_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 24);
            //3.execute & return result
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String lastNmae = resultSet.getString(2);
                String email = resultSet.getString(3);

                //将数据封装成对象
                Customer<Person> customer = new Customer<>(firstName, lastNmae, 18, email);
                System.out.println(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //close resources
            //5.closeResource
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);

        }


    }
}
