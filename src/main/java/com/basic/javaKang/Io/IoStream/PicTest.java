package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: 23236
 * @createTime: 2022/3/13   15:36
 * @description: picture
 **/
public class PicTest {

    //加密
    @Test
    public  void secretPicture(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("he.jpg"));
            fos = new FileOutputStream(new File("secret.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                //增强for循环不会改变原来的值所以不能在此用来加密
                for (int i = 0; i <len ; i++) {
    //                bytes[i] ^= 4;
                    bytes[i]= (byte) (bytes[i]^4);
                }
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos == null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //解密
    @Test
    public  void desecretPicture(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("secret.jpg"));
            fos = new FileOutputStream(new File("desecret.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                //增强for循环不会改变原来的值所以不能在此用来加密
                for (int i = 0; i <len ; i++) {
    //                bytes[i] ^= 4;
                    bytes[i]= (byte) (bytes[i]^4);
                }
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos == null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
