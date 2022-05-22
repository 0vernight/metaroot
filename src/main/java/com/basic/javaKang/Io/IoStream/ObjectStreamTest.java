package com.basic.javaKang.Io.IoStream;

import com.basic.javaKang.bean.Student;
import org.junit.Test;

import java.io.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/14   20:06
 * @description: 内存当中的数据源写道文件当中
 *
 *
 **/
public class ObjectStreamTest {

    //序列化
    //反序列化
    //通过使用ObjectOutputStream
    //
    @Test
    public  void objWrite(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
            oos.writeObject(new String("学业有成，心想事成，与事事顺，天天开心。"));
            Student<Object> student = new Student<>("虾米童鞋欢迎学习");
            oos.writeObject(student);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void objRead(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("student.dat"));
            String str=(String)ois.readObject();
            Student st=(Student)ois.readObject();
            System.out.println(str);
            System.out.println(st);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
