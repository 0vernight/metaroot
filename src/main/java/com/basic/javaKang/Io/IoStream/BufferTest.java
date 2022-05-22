package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/13   15:14
 * @description: buffer
 **/
public class BufferTest {
    public void copyFile(String srcPath,String desPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            File file = new File(srcPath);
            File file1 = new File(desPath);
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            //处理流套接在已有的流上。
            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);


            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
//                String s = new String(bytes, 0, len);
//                System.out.println(s);
                bos.write(bytes,0,len);
            }
            System.out.println("copy seccessfully !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    public void test03(){
        long begin = System.currentTimeMillis();
        String srcPath="LOCKED UP 2 - 6ix9ine_Akon - 单曲 - 网易云音乐.m4a";
        String destPath="media.jpg";
        copyFile(srcPath,destPath);
        long end =System.currentTimeMillis();
        System.out.println("总共用了="+(end - begin));
    }
}
