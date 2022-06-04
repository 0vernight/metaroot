package com.basic.javaKang.jdbc.utils;

import com.basic.javaKang.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/6/4   16:19
 * @description: apache提供的数据工具类
 *
 * 封装了数据库的增删改查操作
 *
 **/
public class QueryRunnerTest {

    @Test
    public void queryAll()  {
        Connection connectionPool = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connectionPool = JDBCUtils.getConnectionPool();
            String sql="select  first_name firstName,last_name lastName,email,address_id addressId from customer where customer_id<? ";
//        All Known Implementing Classes:
//AbstractKeyedHandler, AbstractListHandler, ArrayHandler, ArrayListHandler, BaseResultSetHandler, BeanHandler,
// BeanListHandler, BeanMapHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
            //beanListHandler可以返回多个对象
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = queryRunner.query(connectionPool, sql, handler, 10);
            customers.forEach(System.out::println);
//        System.out.println(customers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connectionPool,null);
        }
    }
    @Test
    public void test1() {
        Connection connectionPool = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connectionPool = JDBCUtils.getConnectionPool();
            String sql="select  first_name firstName,last_name lastName,email,address_id addressId from customer where customer_id=? ";
//        All Known Implementing Classes:
//AbstractKeyedHandler, AbstractListHandler, ArrayHandler, ArrayListHandler, BaseResultSetHandler, BeanHandler,
// BeanListHandler, BeanMapHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
            //beanHandler返回一条数据
            BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
            Customer customer = queryRunner.query(connectionPool, sql, handler, 1);
            System.out.println(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connectionPool,null);
        }
    }
}
