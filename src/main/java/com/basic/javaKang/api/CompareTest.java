package com.basic.javaKang.api;

import com.basic.javaKang.bean.Goods;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: 23236
 * @createTime: 2021/10/6   18:01
 * @description: Java中需要比较对象的大小
 * comparable和comparator
 *
 * Comparable接口的便用裘例:目然排子
 * 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对
 * 2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
 * 3．重写compareTo(obj)的规则:
 * 如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回负整数，如果当前对象this等于形参对象obj，则返回零。
 * 4．对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo
 * 在compareTo(obi)方法中指明如何排序
 **/
public class CompareTest {

    @Test
    public void comparatorTest(){
        //定制排序comparator接口,临时的用一下，比喻：一次性筷子
        //当元素的类型没有实现java.Lang.comparable接口而又不方便修改代码,
        // 或者实现了java.Lang.Comparable接口的排序规则不适合当前的操作，
        // 那么可以考虑使用Comparator 的对象来排序
        String[] arr=new String[]{"anmd","deoo","gool","celocon","bacon"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));

        Goods[] goods=new Goods[4];
        goods[0]=new Goods("dell",5000);
        goods[1]=new Goods("lenovo",3000);
        goods[2]=new Goods("alian",10000);
        goods[3]=new Goods("dell",8000);

        Arrays.sort(goods, new Comparator() {
//            @Override//泛型的写法Comparator<Goods>()
//            public int compare(Goods o1, Goods o2) {
//                return 0;
//            }

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods&& o2 instanceof Goods) {
                    Goods g1=(Goods) o1;
                    Goods g2=(Goods) o2;
                    if (g1.getName().equals(g2.getName()) ) {
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw  new RuntimeException("传入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void comparableTest(){
        //comparabale接口compareto()方法，实现类中实线comparable接口，比喻：反复使用的筷子
        //string和包装类重写了comparable接口
        String[] arr=new String[]{"anmd","deoo","gool","celocon","bacon"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Goods[] goods=new Goods[3];
        goods[0]=new Goods("dell",5000);
        goods[1]=new Goods("lenovo",3000);
        goods[2]=new Goods("alian",10000);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

}
