package com.basic.javaKang.Net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author: 23236
 * @createTime: 2022/3/15   22:36
 * @description: tcp/ip
 **/
public class TCPTest {

    @Test
    public void cilent(){
        Socket socket = null;
        OutputStream ops = null;
        try {
            InetAddress destIp = InetAddress.getByName("127.0.0.1");
            socket = new Socket(destIp, 8899);

            ops = socket.getOutputStream();
            ops.write("服务器端美女等着我会学会你".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ops != null) {

                try {
                    ops.close();
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
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            accept = ss.accept();
            is = accept.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[20];
            int len;
            while ((len=is.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos == null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is == null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept == null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss == null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void serverTest(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        BufferedReader baos = null;
        try {
            ss = new ServerSocket(8899);
            accept = ss.accept();
            is = accept.getInputStream();

            //通过转换流来实现服务器端接收信息
            baos = new BufferedReader(new InputStreamReader(is));
            byte[] bytes = new byte[20];
            char[] chars = new char[1024];
            int l;
            while ((l = baos.read(chars)) != -1) {
                System.out.println(new String(chars, 0, l));
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos == null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is == null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept == null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss == null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
