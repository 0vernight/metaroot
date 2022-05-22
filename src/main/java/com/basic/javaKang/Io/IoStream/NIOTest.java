package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: 23236
 * @createTime: 2022/3/14   22:13
 * @description: path ,paths, files
 **/
public class NIOTest {

    @Test
    public  void NIOtest01(){

        BufferedOutputStream mike = null;
        try {
            //NIO2 中的File files paths
            Path path1=Paths.get("niomike.txt");
            File f=path1.toFile();
            mike = new BufferedOutputStream(new FileOutputStream(f));
            byte[] bytes = new byte[20];
            bytes=(new String("welcome to do new things ")).getBytes(StandardCharsets.UTF_8);
            mike.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (mike != null) {

                try {
                    mike.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
