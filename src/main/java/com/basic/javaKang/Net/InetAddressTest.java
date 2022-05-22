package com.basic.javaKang.Net;

import org.junit.Test;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: 23236
 * @createTime: 2022/3/15   21:49
 * @description: 网络编程
 **/
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetName = Inet6Address.getByName("127.0.0.1");// 192.168.1.1
            System.out.println(inetName);

            InetAddress inet2 = InetAddress.getByName("www.ulinix.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("localhost");
            System.out.println(inet3);
            System.out.println(InetAddress.getLocalHost());
            //不同的进程对应不同的端口号


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){

    }
}
