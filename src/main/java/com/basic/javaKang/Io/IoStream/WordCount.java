package com.basic.javaKang.Io.IoStream;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: 23236
 * @createTime: 2022/3/13   16:33
 * @description: counter
 **/
public class WordCount {

    @Test
    public void test01(){

        BufferedInputStream br = null;
        BufferedWriter bw = null;
        try {
            Map<Character,Integer> map=new HashMap<>();
            br = new BufferedInputStream(new FileInputStream(new File("mai.txt")));
            bw = new BufferedWriter(new FileWriter(new File("wordcount.txt")));
            byte[] bytes = new byte[1024];
            int c;
            while ((c=br.read(bytes))!=-1){
                for (int i = 0; i < c; i++) {
                    if (!map.containsKey((char)bytes[i])){
                        map.put((char) bytes[i],1);
                    }else {
                        map.put((char) bytes[i],map.get((char)bytes[i])+1);
                    }
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()){
                    case ' ':bw.write("空格="+entry.getValue());
                    break;
                    case '\t':bw.write("tab键="+entry.getValue());break;
                    case '\r':bw.write("回车="+entry.getValue());break;
                    case '\n':bw.write("换行="+entry.getValue());break;
                    default:
                        bw.write((char) entry.getKey()+"="+entry.getValue());
                }
                bw.newLine();
            }
            System.out.println("统计完毕！请查收！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
