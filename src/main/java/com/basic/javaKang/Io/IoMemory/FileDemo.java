package com.basic.javaKang.Io.IoMemory;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: 23236
 * @createTime: 2022/3/10   19:20
 * @description: file demo
 **/
public class FileDemo {
    private int fileLength=0;

    @Test
    public void test01() throws IOException {
        File file = new File("D:\\Program Files (x86)\\IdeaProjects\\mike\\BasicJava\\jdbc.properties");
        //创建与file同目录下的另一个文件，文件名为米克.txt
        String path=file.getParent();
        System.out.println("path="+path);
        File file1 = new File(path + File.separator + "mike.txt");
//        boolean mkdirs = file1.mkdirs();//创建目录为file1的文件夹
        boolean b = file1.createNewFile();//创建file文件
        System.out.println("result="+b);
    }

    @Test
    public void test02() throws IOException {
        //判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        File file = new File("D:\\Program Files (x86)\\IdeaProjects\\mike\\BasicJava\\jdbc.properties");
        String path=file.getParent();
        System.out.println("path="+path);
        File file1 = new File(path);
        System.out.println(file1.getAbsolutePath() == file1.getPath());
        File file2 = new File(path + File.separator + "maimai.txt");
        System.out.println("create maimai ="+file2.createNewFile());
        String[] list = file1.list();
        for (String s : list) {
            if (s.endsWith(".jpg")){
                System.out.println(path +File.separator+ s);
            }
            System.out.println(s);
        }
        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
        File file3 = new File(path + File.separator + "maimai.txt");
        System.out.println("delete maimai ="+file3.delete());
    }
    @Test
    public void test03(){
        //遍历指定文件目录所有的文件名称，包括所有子文件的文件名称
        File file = new File("D:\\Program Files (x86)\\IdeaProjects\\mike\\BasicJava");
        String path=file.getParent();
        System.out.println("path="+path);
        File file1 = new File(path);
        String[] list = file1.list();
        printSubFile(file);
        System.out.println("all file length="+fileLength);
    }
    public  void printSubFile(File file){
        File[] files = file.listFiles();
        for (File s : files) {
            if (s.isDirectory()) {
                System.out.println("目录名="+s);
                printSubFile(s);
            }else {
                if (s.isFile()){
                    fileLength+=s.length();
                    System.out.println("文件名="+s.getAbsolutePath());
                }
            }
        }

    }
}
