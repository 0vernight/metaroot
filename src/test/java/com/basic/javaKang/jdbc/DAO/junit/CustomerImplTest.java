package com.basic.javaKang.jdbc.DAO.junit;

import com.basic.javaKang.bean.Customer;
import com.basic.javaKang.jdbc.Impl.CustomerImpl;
import com.basic.javaKang.jdbc.crud.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

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
        }
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void getCustomers() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getCount() {
    }
}