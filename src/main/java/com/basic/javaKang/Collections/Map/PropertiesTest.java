package com.basic.javaKang.Collections.Map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author: 23236
 * @createTime: 2022/3/5   20:38
 * @description: 处理配置文件
 **/
public class PropertiesTest {

    //    Properties是配置文件，key和value都是用string
    public static void main(String[] args) {//throws Exception {//FileNotFoundException异常，跑大一点
        FileInputStream fis= null;
        try {
            Properties properties = new Properties();
            fis = new FileInputStream("BasicJava//jdbc.properties");

            properties.load(fis);
            String name = properties.getProperty("name", "defualt");
            String password = properties.getProperty("password", "mike....");
//        String name = properties.getProperty("name");
//        String password = properties.getProperty("password");
            System.out.println("name="+name+"   password="+password);
            Enumeration<?> names = properties.propertyNames();
            System.out.println("enumeration="+names.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }
}
