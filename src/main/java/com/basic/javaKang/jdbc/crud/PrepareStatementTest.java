package com.basic.javaKang.jdbc.crud;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: 23236
 * @createTime: 2022/5/21   19:16
 * @description: crud
 **/
public class PrepareStatementTest {


    @Test
    public void testCommonTest(){
        String sql="insert into customer (first_name,last_name,email,address_id) values(?,?,?,?)";
        update(sql,"3nasirdin","apndali","3446@.com","22");
    }
    //通用的增删改
    public  void  update (String sql,Object ...args) {//...可变形参
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.return preparestatement
            preparedStatement = connection.prepareStatement(sql);
            //3.set args into sql
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //4.execute
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //5.closeResource
            JDBCUtils.closeResource(connection,preparedStatement);
        }


    }

    @Test
    public void cudTest() {
//        System.out.println("连接数据库begin");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1.读取配置文件的信息
//            InputStream  resourceAsStream= JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");//加载器当中的系统加载器
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

            System.out.println("链接结束="+connection);

            //4.预编译sql，返回prepare Statement实例
            String sql =" insert into customer (first_name,email) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);

            //5.填充占位符
            preparedStatement.setString(1,"jdbc_cud");
            preparedStatement.setString(2,"3456@qq.com");

            //6.执行操作
            preparedStatement.execute();

            System.out.println("执行成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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



    }




    @Test
    public void  test2(){
        Connection connection= null;
        PreparedStatement  preparedStatement  = null;
        try {
            //1.链接数据库
            connection=JDBCUtils.getConnection();

            //2.预编译sql 返回prepareStatement
            String sql="insert into customer (first_name,email) values (?,?) ";
            preparedStatement = connection.prepareStatement(sql);


            //3.填充占位符
            preparedStatement.setString(1,"封装后添加的数据");
            preparedStatement.setString(2,"封装2345@.com");

            //4.执行
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }
    /**
     * 增删改的操作都是一样的
     * 可以进一步封装
     *
     */


}
