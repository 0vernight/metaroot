package com.basic.javaKang.jdbc.crud;

import com.basic.javaKang.bean.User;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @Author: 23236
 * @createTime: 2022/5/29   14:48
 * @description: 保存图片格式的数据在数据库中
 **/
public class BlobTest {

    @Test
    public void queryTest() {
        Connection connection = null;
        PreparedStatement pS = null;
        InputStream binaryStream = null;
        FileOutputStream fileOutputStream= null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql ="select user_name name,user_age age,user_address address,user_img img from user where iduser=?";
            pS = connection.prepareStatement(sql);

            pS.setObject(1,1);

            resultSet = pS.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");

                User user = new User(name, age, address);
                System.out.println(user);
                Blob img = resultSet.getBlob("img");
                binaryStream = img.getBinaryStream();

                fileOutputStream = new FileOutputStream("mon.jpg");
                byte[] bytes = new byte[1024];
                int len=0;
                while ((len=binaryStream.read(bytes))!=-1){
                    fileOutputStream.write(bytes,0,bytes.length);
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (binaryStream != null) {

                    binaryStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fileOutputStream != null) {

                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JDBCUtils.closeResource(connection,pS,resultSet);

        }



    }
    @Test
    public void insertTest() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql ="insert into user (user_name,user_age,user_address,user_img) values(?,?,?,?)";
        PreparedStatement pS = connection.prepareStatement(sql);

        pS.setObject(1,"其蓝");
        pS.setObject(2,22);
        pS.setObject(3,"loacation name");

        FileInputStream fileInputStream = new FileInputStream(new File("D:\\Users\\Mike\\Pictures\\Saved Pictures\\Camera Roll\\images\\montain.jpg"));
        pS.setBlob(4,fileInputStream);
        pS.execute();

        JDBCUtils.closeResource(connection,pS);


    }
}
