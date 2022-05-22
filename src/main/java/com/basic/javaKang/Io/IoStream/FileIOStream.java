package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/13   13:27
 * @description: copy one pictue to another
 *
 *  *      抽象基类  ：      节点流：（文件流）       缓冲流(实际上用这个用的多)
 *  *字节  InputStream      FileInputStream     BufferedInputStream
 *  *字节  OutPutStream     FileOutPutStream    BufferedOutputStream
 *  *字符  Reader           FileReader          BufferReader
 *  *字符  Writer           FileWriter          BufferWriter
 *  *
 **/
public class FileIOStream {

    @Test
    public void test01() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File file = new File("he.jpg");
            File file1 = new File("man.jpg");
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);

            char[] chars=new char[4];
            int len;
            while ((len=fileReader.read(chars))!=-1){       //每次返回读取的长度
    //            System.out.print(new String(chars,0,len));
                //写到文件当中
                fileWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test02()   {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("LOCKED UP 2 - 6ix9ine_Akon - 单曲 - 网易云音乐.m4a");
            File file1 = new File("man.m4a");
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            byte[] bytes = new byte[2];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                String s = new String(bytes, 0, len);
                System.out.println(s);
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("copy seccessfully !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileOutputStream != null)
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void copyFile(String srcPath,String desPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(desPath);
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            byte[] bytes = new byte[1024];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                String s = new String(bytes, 0, len);
                System.out.println(s);
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("copy seccessfully !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fileOutputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    public void test03(){
        long begin = System.currentTimeMillis();
        String srcPath="LOCKED UP 2 - 6ix9ine_Akon - 单曲 - 网易云音乐.m4a";
        String destPath="media";
        copyFile(srcPath,destPath);
        long end =System.currentTimeMillis();
        System.out.println("总共用了="+(end - begin));
    }
}
