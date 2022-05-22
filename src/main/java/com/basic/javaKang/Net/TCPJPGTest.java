package com.basic.javaKang.Net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author: 23236
 * @createTime: 2022/3/19   13:18
 * @description: socket 传输文件
 **/
public class TCPJPGTest {

    @Test
    public  void client (){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos= null;
        try {
            InetAddress ad = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ad, 8889);
            outputStream = socket.getOutputStream();
            fis = new FileInputStream(new File("man.jpg"));
            bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            //给服务器端一个结束传输的指令
            socket.shutdownOutput();
            System.out.println("照片发送完毕！");
            //接受服务器端的数据显示
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len1;
            while((len1=is.read(buffer))!=-1){
                baos.write(buffer,0,len1);
            }
            //显示服务器端返回的信息
            System.out.println("result="+baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;

        try {
            ss = new ServerSocket(8889);
            socket = ss.accept();
            inputStream = socket.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream(new File("server.jpg")));

            byte[] bytes = new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            System.out.println("照片保存完毕！");
            //给客户端反馈
            os = socket.getOutputStream();
            os.write("保存图片成功了！".getBytes(StandardCharsets.UTF_8));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os == null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
