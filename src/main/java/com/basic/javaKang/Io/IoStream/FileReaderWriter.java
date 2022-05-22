package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: 23236
 * @createTime: 2022/3/11   20:37
 * @description: 流
 *      抽象基类  ：      节点流：（文件流）       缓冲流
 *字节  InputStream      FileInputStream     BufferedInputStream
 *字节  OutPutStream     FileOutPutStream    BufferedOutputStream
 *字符  Reader           FileReader          BufferReader
 *字符  Writer           FileWriter          BufferWriter
 *
 **/
public class FileReaderWriter {
    public static void main(String[] args) {
        File file = new File("mike.txt");//相当与当前的工程目录下
        System.out.println(file.length());
        System.out.println(file.getAbsolutePath());
        File file1 = new File("D:\\Program Files (x86)\\IdeaProjects\\mike\\BasicJava\\jdbc.properties");
        System.out.println(file1.length());
        File file2 = new File("\\BasicJava","mike.txt");
        System.out.println(file2.length());
        System.out.println(file2.getAbsolutePath());
        File file3 = new File("BasicJava\\","mike.txt");
        System.out.println(file3.length());
        System.out.println(file3.getAbsolutePath());
    }

    @Test
    public  void test01() {
        FileReader fileReader = null;
        try {
            //这里抛出的异常最好使用trycatchfinally
            //读出mike.txt 文件内容输出controller
            //1.实例化file 对象
            File file = new File("mike.txt");//相当与当前的工程目录下
            System.out.println(file.length());
            System.out.println(file.getAbsolutePath());
            //2.提供具体的流
            fileReader = new FileReader(file);
            //3.数据读出
//        //3.1
//        int read = fileReader.read();
//        while (read!=-1){       //到了文件末尾返回-1， The character read, or -1 if the end of the stream has been reached
//            System.out.print((char) read);
//            read=fileReader.read();
//        }
            //3.2
            int read;
            while ((read= fileReader.read())!=-1){       //到了文件末尾返回-1， The character read, or -1 if the end of the stream has been reached
                System.out.print((char) read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    @Test
    public  void testFileReader1() {
        FileReader fileReader = null;

        try {
            //这里抛出的异常最好使用trycatchfinally
            //读出mike.txt 文件内容输出controller
            //1.实例化file 对象
            File file = new File("mike.txt");
            //2.提供具体的流
            fileReader = new FileReader(file);

            //3.数据读出
//        //3.1
            char[] chars=new char[5];
            int len;
            while ((len=fileReader.read(chars))!=-1) {      //每次返回
//                System.out.print(chars);
//                3.1.1错误的写法
//                for (int i = 0; i < chars.length; i++) {
//                    System.out.print(chars[i]);
//                }
////                3.1.2还是错误，原因呢跟第一一模一样
//                String str=new String(chars);
//                System.out.print(str);
////                3.1.3正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
//                3.1.4正确的写法
                String str=new String(chars,0,len);
                System.out.print(str);



            }
            //3.2
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.流的关闭
            try {
                if (fileReader != null) {

                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }




    @Test
    public void testFileWriter() throws IOException {
        File file = new File("mai.txt");
        FileWriter fileWriter = new FileWriter(file,true);      //第二个参数不写相当与false 默认是false

        fileWriter.write("米克have a dream it is a weapon\n");
        fileWriter.write("everybody must be happy");
        fileWriter.close();     //如果没有关闭就不会写进去，什么原因？

    }




}
