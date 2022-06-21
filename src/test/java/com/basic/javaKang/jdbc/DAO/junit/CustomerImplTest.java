package com.basic.javaKang.jdbc.DAO.junit;

import com.basic.javaKang.bean.Customer;
import com.basic.javaKang.jdbc.DAO.Impl.CustomerImpl;
import com.basic.javaKang.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/5/29   23:08
 * @description:
 **/
class CustomerImplTest {

    CustomerImpl dao=new CustomerImpl();

    @Test
    void insert() {
//        String sql="insert into customer (first_name,last_name,email,address_id) values(?,?,?,?)";
        Connection connection = null;
        Customer customer = new Customer("喀秋莎", "apndali", 22,"3456@com","苏维埃共和国");
        try {
            connection = JDBCUtils.getConnection();
            dao.insert(connection,customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    void deleteById() {
        Connection connection= null;
        try {
            connection=JDBCUtils.getConnection();
            int i = dao.deleteById(connection, 35);
            if (i >0) {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,null);
        }


    }

    @Test
    void updateById() {
        Connection connection= null;
        Customer yiltiz = new Customer(36,"3apndi", "yiltiz", 18, "2323@qq.com");
        try {
            connection=JDBCUtils.getConnection();
            int i = dao.updateById(connection, yiltiz);
            if (i >0) {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    void getCustomers() {
        Connection connection= null;
        try {
            connection=JDBCUtils.getConnection();
            Customer customers = dao.getCustomers(connection, 36);

            System.out.println(customers);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    void getAll() {
        Connection connection= null;
        try {
//            connection=JDBCUtils.getConnection();
            //用数据库连接池
            connection = JDBCUtils.getConnectionPool();
            List<Customer> all = dao.getAll(connection);
            all.forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    @Test
    void getCount() {
        Connection connection= null;
        try {
            connection=JDBCUtils.getConnection();
            long i = dao.getCount(connection);
            System.out.println("总共查询到的数据条数为："+i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
}