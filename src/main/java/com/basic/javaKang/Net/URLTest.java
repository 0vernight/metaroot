package com.basic.javaKang.Net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: 23236
 * @createTime: 2022/3/19   21:00
 * @description: url
 **/
public class URLTest {
    public static void main(String[] args)  {

        URL url = null;
        try {
            url = new URL("http://localhost:8080/example/index.html?user=m&id=0");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());


        URLConnection urlConnection = null;
        HttpURLConnection urlConnection1 = null;
        InputStream inputStream = null;
        BufferedOutputStream bos = null;
        try {
            urlConnection = url.openConnection();
            urlConnection1 = (HttpURLConnection)url.openConnection();

            urlConnection1.connect();
            inputStream = urlConnection1.getInputStream();
            //读取的内容写到文件当中
            bos = new BufferedOutputStream(new FileOutputStream(new File("http.txt")));
            byte[] bytes = new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                bos.write(bytes,0,bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            urlConnection1.disconnect();
            urlConnection.getDoInput();

        }

    }
}
