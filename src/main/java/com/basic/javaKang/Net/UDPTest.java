package com.basic.javaKang.Net;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: 23236
 * @createTime: 2022/3/19   20:40
 * @description: udp
 **/
public class UDPTest
{


    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress inet= InetAddress.getLocalHost();//getByName()

        String msg="udp 传输不会等待链接只管发送！所以要记录目的地";
        byte[] bytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,inet,8890);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void resiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(8890);

        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
