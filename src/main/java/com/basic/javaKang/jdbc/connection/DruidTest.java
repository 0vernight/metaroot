package com.basic.javaKang.jdbc.connection;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: 23236
 * @createTime: 2022/6/4   14:38
 * @description: druid测试，阿里巴巴数据库连接池
 **/
public class DruidTest {

    @Test
    public void getConnection() throws Exception {
        //任何数据库连接池都实现了datasource接口
        DataSource dataSource=null;
        DruidDataSource druidDataSource = new DruidDataSource();

        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pros);

        Connection connection = ds.getConnection();
        System.out.println(connection);



    }
}
