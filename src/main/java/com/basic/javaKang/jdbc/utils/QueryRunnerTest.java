package com.basic.javaKang.jdbc.utils;

import com.basic.javaKang.bean.Customer;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: 23236
 * @createTime: 2022/6/4   16:19
 * @description: apache提供的数据工具类
 *undeniable good 不可否认的好
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
//            JDBCUtils.closeResource(connectionPool,null);

            //工具类提供了现成的关闭工具类DbUtils
            try {
                DbUtils.close(connectionPool);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //上面下面两个都可以
            DbUtils.closeQuietly(connectionPool);

        }
    }
    @Test
    public void queryAllMap()  {
        Connection connectionPool = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connectionPool = JDBCUtils.getConnectionPool();
            String sql="select  first_name firstName,last_name lastName,email,address_id addressId from customer where customer_id<? ";
//        All Known Implementing Classes:
//AbstractKeyedHandler, AbstractListHandler, ArrayHandler, ArrayListHandler, BaseResultSetHandler, BeanHandler,
// BeanListHandler, BeanMapHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
            //mapHandler

            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> mapList = queryRunner.query(connectionPool, sql, handler, 10);
            mapList.forEach(System.out::println);
//        System.out.println(customers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connectionPool,null);
        }
    }
    @Test
    public void testScalar()  {
        Connection connectionPool = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connectionPool = JDBCUtils.getConnectionPool();
            String sql="select  count(*) from customer ";
//        All Known Implementing Classes:
//AbstractKeyedHandler, AbstractListHandler, ArrayHandler, ArrayListHandler, BaseResultSetHandler, BeanHandler,
// BeanListHandler, BeanMapHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
            //mapHandler

            ScalarHandler handler = new ScalarHandler();
            long count = (long) queryRunner.query(connectionPool, sql, handler);

            System.out.println(count);

//        System.out.println(customers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connectionPool,null);
        }
    }
    @Test
    public void testself()  {
        Connection connectionPool = null;

        try {
            QueryRunner queryRunner = new QueryRunner();
            connectionPool = JDBCUtils.getConnectionPool();
            String sql="select  first_name firstName,last_name lastName,email,address_id addressId from customer ";
//        All Known Implementing Classes:
//AbstractKeyedHandler, AbstractListHandler, ArrayHandler, ArrayListHandler, BaseResultSetHandler, BeanHandler,
// BeanListHandler, BeanMapHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
            //mapHandler

            ResultSetHandler<Customer> handler = new ResultSetHandler<>() {
                @Override
                public Customer handle(ResultSet rs) throws SQLException {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    while (rs.next()) {
                        String fistName = rs.getString("firstName");
                        String email = rs.getString("email");
                        Customer<Customer> customer= new Customer<>(fistName,fistName,18,email);
                        return customer;
                    }
                    //正常结束就返回正常的值
                    return null;

                }
            };

            Customer customer = queryRunner.query(connectionPool, sql, handler);

            System.out.println(customer);

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
