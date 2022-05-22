package com.basic.javaKang.Generic;

import java.util.*;

/**
 * @Author: 23236
 * @createTime: 2022/3/8   21:40
 * @description: data access object
 * DAO
 * ORM
 * 操作数据库的通用的操作类
 *
 * 我们在Java中对应与数据库每一张表是一个类
 *
 *
 *
 **/
public class DAO <T>{
    private Map<String,T> map=new HashMap<>();
    public void save(String key,T entity){
        map.put(key,entity);
    }
    public T get(String key){
        return map.get(key);
    }
    public void update(String key,T entity){
        if (map.containsKey(key)){
            map.put(key,entity);
        }
    }
    public List<T> list(){
        //错误的
//        Collection<T> values = map.values();
//        return (List<T>) values;
        //正确的
        Collection<T> values = map.values();
        ArrayList<T> list = new ArrayList<>();
        for (T t :
                values) {
            list.add(t);
        }
        return list;
    }
    public void delete(String key){
        map.remove(key);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }

    //添加一条记录
    public  void add(T t){

    }

    //删除一条记录
    public boolean remove(int index){
        return false;
    }
    //修改一条记录
    public T update(int index ,T t){
        return t;
    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getList(int index){
        return null;
    }
    //不确定
    public <T> T getValue(){
        return null;
    }
}
