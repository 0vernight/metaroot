package com.basic.javaKang.NewFeature;


import com.basic.javaKang.bean.Person;
import com.basic.javaKang.bean.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: 23236
 * @createTime: 2022/4/4   17:19
 * @description: stream
 **/
public class StreamAPITest {

    @Test
    public void test01() {
        Student<Object> s1 = new Student<>("must ");
        Student<Object> s2 = new Student<>("be ");
        Student<Object> s3 = new Student<>("success ");
        Student<Object> s4 = new Student<>("all about ");
        Student[] students = {s1, s2, s3};
        List<Student> list = Arrays.asList(students);

        Stream<Student> stream = list.stream();
        stream.filter(s -> s.getName().contains("m")).forEach(System.out::println);

        list.stream().limit(2).forEach(System.out::println);
        list.stream().skip(2).forEach(System.out::println);

    }

    @Test
    public void test02() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream1 = Arrays.stream(arr);

        Student<Object> s1 = new Student<>("must ");
        Student<Object> s2 = new Student<>("be ");
        Student<Object> s3 = new Student<>("success ");
        Student<Object> s4 = new Student<>("mike ");
        Student[] students = new Student[]{s1, s2, s3, s4};

        //想要用sorted那么这个类必须实现comparable接口或者指定的排序方式来调用（person实现了接口在这里用定制）
        Stream<Student> stream2 = Arrays.stream(students);
        stream2.sorted((st1, st2) -> {
            int compare = Integer.compare(st1.getAge(), st2.getAge());
            if (compare != 0) {
                return compare;
            } else {

                return -st1.getName().compareTo(st2.getName());
            }
        }).forEach(System.out::println);

        System.out.println();
        Stream<Student> stream3 = Arrays.stream(students);
        List<Student> m = stream3.filter(ss -> ss.getName().contains("m")).collect(Collectors.toList());
        m.forEach(System.out::println);


    }

    @Test
    public void test03() {

        Stream<Double> doubleStream = Stream.of(8.8, 6.6, 1.2, 2.2, 3.4, 4.5, 4.6);       //包装类来处理

        doubleStream.sorted().forEach(System.out::println);

        List<Double> doubleList = Arrays.asList(8.8, 6.6, 1.2, 2.2, 3.4, 4.5, 4.6);
        Double reduce = doubleList.stream().reduce(0.0, Double::sum);  //零是初始值

        System.out.println(reduce);
    }

    @Test
    public void test04() {
        //创建无限流
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);    //输出前十个偶数，没有limit 会一直输出（无限）
        // 生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test05() {
        Person person = new Person("mike", 18);
        System.out.println(person);
    }
}
