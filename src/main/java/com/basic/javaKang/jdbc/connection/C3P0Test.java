package com.basic.javaKang.jdbc.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author: 23236
 * @createTime: 2022/5/30   21:42
 * @description: C3P0连接池的测试
 *
 * 前面一直导包不行的原因是包没导入对
 **/
public class C3P0Test {

    @Test
    public  void getConnection() throws Exception {


        // 创建连接池对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        // 四大参数
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/db1");
        ds.setUser("root");
        ds.setPassword("747699");

        // 池配置
        ds.setAcquireIncrement(5);    // 自增数
        ds.setInitialPoolSize(20);    // 初始容量
        ds.setMinPoolSize(2); // 最小连接数
        ds.setMaxPoolSize(50);    // 最大连接

        Connection conn = ds.getConnection();    // 获取连接
        System.out.println(conn);
        conn.close();    // 归还连接
    }
}
