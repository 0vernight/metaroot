package com.basic.javaKang.jdbc.crud;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: 23236
 * @createTime: 2022/5/21   20:30
 * @description: 链接数据的工具类
 **/
public class JDBCUtils {

    public static Connection getConnection() {
//        System.out.println("连接数据库begin");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1.读取配置文件的信息
            //InputStream resourceAsStream = JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");//加载器当中的系统加载器
            InputStream  resourceAsStream= ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");//也跟上面的一样
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            //2.记载驱动
            Class.forName(driverClass);

            //3.获取链接
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("链接成功结束=" + connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void closeResource(Connection connection, Statement preparedStatement) {
        //7.资源关闭
        try {
            if (preparedStatement != null) {//避免对象没有创建就要关闭的判断
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void closeResource(Connection connection, Statement preparedStatement,ResultSet resultSet) {
        //7.资源关闭
        try {
            if (preparedStatement != null) {//避免对象没有创建就要关闭的判断
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}
