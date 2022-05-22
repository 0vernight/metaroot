package com.basic.javaKang.jdbc;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Orale extends JDBC {
    @Override
    public void connect() throws Exception {
        System.out.println("连接数据库begin");

        //1.读取配置文件的信息
        InputStream resourceAsStream = JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");//加载器当中的系统加载器
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String user = properties.getProperty("userO");
        String password = properties.getProperty("passwordO");
        String url = properties.getProperty("urlO");
        String driverClass = properties.getProperty("driverClassO");

        //2.记载驱动
        Class.forName(driverClass);

        //3.获取链接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("链接结束="+connection);

    }
    public void sellect(){
        System.out.println("Oracle查询");
    }
}
