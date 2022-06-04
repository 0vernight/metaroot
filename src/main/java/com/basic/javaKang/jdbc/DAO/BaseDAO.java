package com.basic.javaKang.jdbc.DAO;

import com.basic.javaKang.jdbc.utils.JDBCUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 23236
 * @createTime: 2022/5/29   21:48
 * @description: 封装了对于数据表的通用操作
 *
 * DAO  data bases access object
 *
 **/

//本类不会去创建他的对象的，只是提供通用的方法的的类
    //所以虽然没有抽象方法但是还是定义为抽象类
    //后续具体的表提供具体的dao
public abstract class BaseDAO<T> {

    private Class<T> clazz=null;

//    public BaseDAO(){
//        clazz=
//    }

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();//获取了父类 的泛型参数
        clazz = (Class<T>) actualTypeArguments[0];
    }
    //链接也是一个事务，
    public int update(Connection conn,String sql,Object... args){
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(null,ps);
        }
    }

    public  <T> List<T> queryList(Connection connection,Class <T> claz, String sql, Object... args) {

        ArrayList<T> types = null;
//        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            types = new ArrayList<T>();

            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.prepare sql return preparestatement
//            sql = "select first_name,last_name,email from customer where customer_id=?";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);

            }
            //3.execute & return result
            resultSet = preparedStatement.executeQuery();

            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                //Customer<Person> cust = new Customer<>();
                //不确定是那个表的，用泛型
                T t= (T) clazz.getDeclaredConstructor().newInstance();
                //处理结果集当中的每一行数据
                for (int i = 0; i < columnCount; i++) {
                    //获取某一列的值
                    Object custValue = resultSet.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给cust对象的columnName 赋值为custValue通过反射来实现
                    Field field = clazz.getDeclaredField(columnName);
                    //如果不设置下面的语句将不能访问该泛型下的私有属性
                    //cannot access a member of class com.basic.javaKang.bean.Student with modifiers "private"
                    field.setAccessible(true);
                    field.set(t, custValue);

                }

                //                String firstName = resultSet.getString(1);
                //                String lastNmae = resultSet.getString(2);
                //                String email = resultSet.getString(3);
                //
                //                //将数据封装成对象
                //                Customer<Person> customer = new Customer<>(firstName, lastNmae, 18, email);
                //                System.out.println(customer);
                //                customers.add(customer);
                types.add(t);
            }
            //正常结束就返回正常的值
            return types;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //close resources
            //5.closeResource
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        //如果出现了异常的话就返回空
        return null;

    }
    public  <T> T getInstance(Connection connection,Class <T> clazz, String sql, Object... args) {

        ArrayList<T> types = null;
//        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            types = new ArrayList<T>();

            //1.connect db
            connection = JDBCUtils.getConnection();
            //2.prepare sql return preparestatement
//            sql = "select first_name,last_name,email from customer where customer_id=?";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1, args[i]);

            }
            //3.execute & return result
            resultSet = preparedStatement.executeQuery();

            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                //Customer<Person> cust = new Customer<>();
                //不确定是那个表的，用泛型
                T t=clazz.getDeclaredConstructor().newInstance();
                //处理结果集当中的每一行数据
                for (int i = 0; i < columnCount; i++) {
                    //获取某一列的值
                    Object custValue = resultSet.getObject(i + 1);

                    //获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给cust对象的columnName 赋值为custValue通过反射来实现
                    Field field = clazz.getDeclaredField(columnName);
                    //如果不设置下面的语句将不能访问该泛型下的私有属性
                    //cannot access a member of class com.basic.javaKang.bean.Student with modifiers "private"
                    field.setAccessible(true);
                    field.set(t, custValue);

                }

                //                String firstName = resultSet.getString(1);
                //                String lastNmae = resultSet.getString(2);
                //                String email = resultSet.getString(3);
                //
                //                //将数据封装成对象
                //                Customer<Person> customer = new Customer<>(firstName, lastNmae, 18, email);
                //                System.out.println(customer);
                //                customers.add(customer);
                types.add(t);
            }
            //正常结束就返回正常的值
            return types.get(0);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //close resources
            //5.closeResource
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        //如果出现了异常的话就返回空
        return null;

    }

    //用于查询特殊值的方法
    public <T> T getValue(Connection connection,String sql,Object... args){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (T) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(null,preparedStatement);
        }

        return null;
    }
}
