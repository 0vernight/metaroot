package com.basic.javaKang.api;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: 23236
 * @createTime: 2021/10/4 20:20
 * @description: 关于日期与时间的API
 **/
public class DateTimeTest {

    @Test
    public void calendarDateTime(){
        //时间的格式化和解析 DateTimeFormatter
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String sdate=dtf1.format( dateTime);
        System.out.println(sdate);

        //最重要的方式三自定义格式 ofPatter()
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");//"yyyy-MM-dd hh:mm:ss ae"
        String dd=formatter.format(dateTime);
        System.out.println(dd);

        //解析
        TemporalAccessor parse = formatter.parse("2024-10-06 01:31:53");
        System.out.println(parse);
    }
    @Test
    public void newDateTime(){
        //LocalDate
        //localTime
        //LocalDateTime
        //now()获取当前的日期时间  ，日期+时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(now);
        System.out.println(now1);
        System.out.println(dateTime);

        //of():设置指定的年月日没有偏移量
        //localDateTime()使用频率较高
        dateTime=LocalDateTime.of(2024,10,06,12,25);
        System.out.println(dateTime);

        //getXXX()
        System.out.println(dateTime.getDayOfYear());

        //local是不可变性
        //.withxx是设置
        LocalDateTime dateTime1=dateTime.withYear(2025);
        System.out.println(dateTime);
        System.out.println(dateTime1);

        //加减。.plusxx .minusxx

        //时间戳
        Instant instant = Instant.now();
        System.out.println(instant);

        //设置时区东八区
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long l = instant.toEpochMilli();
        System.out.println(l);

        Instant instant1 = Instant.ofEpochMilli(1833495580956L);
        System.out.println(instant1);
    }
    @Test
    public void calendarTest() throws ParseException {
        //    Calendar类,抽象类
        //实例化方式一:创建其子类GregorianCalendar的对象,方式二:调用其静态方法getInstance()
//    Calendar calendar=new GregorianCalendar();
        Calendar calendar=Calendar.getInstance();
        //常用方法
        //get,set, add,getTime,setTime
        String d="1990-01-21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedate = sdf.parse(d);
//        System.out.println(parsedate);
        calendar.setTime(parsedate);
        int days=calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
    }

    //练习一:从前端获得输入的字符串"2020-09-08”转换为java.sql.Date，保存到数据库当中。
    //练习二:“三天打渔两天晒网”1990-01-01xxxx-xx-xx打渔?晒网?0-4筛网((parsedate.getTime() - date2.getTime())/(1000*3600*24))%5
    @Test
    public void testExcer() throws ParseException {
        String date="2024-01-30";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedate = simpleDateFormat.parse(date);
        Date date2 = new Date();
        System.out.println(((parsedate.getTime() - date2.getTime())/(1000*3600*24)+1)%5);
        java.sql.Date date1 = new java.sql.Date(parsedate.getTime());//转utilsDate为sql.Date的方法
        System.out.println(date1);
    }

    //1.System类中的currentTimeMillis();1970年1月1日0时0分0秒到现在的毫秒为单位的时间戳
    //2.sql.date/util.date
    //3.simpleDateFormate()
    //4.Calendar
    @Test
    public void dateTime() throws ParseException {
//        SimpleDateFormat的对日期Date的格式化和解析
        //格式化：日期-->字符串
        //解析：字符串-->日期
//        SimpleDateFormat的实例化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        Date date = new Date();
        System.out.println(date);
        String d=sdf.format(date);
        System.out.println(d);
        //解析
        String dd="2024-10-05 15:26:34";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf1.parse(dd);
        System.out.println(parse);

    }
    // 1.System类中的currentTimeMillis();1970年1月1日0时0分0秒到现在的毫秒为单位的时间戳
    //Date1.两个构造器和2.两个方法
    //  1.new Date()   new Date(currentTimeMillis()or getTime())
    //  2.toString()  getTime()
    //sqldate->utildate  gettime() ->new utildate(gettime())||Date date=java.sql.Date(currentTimeMillis());//多态，子转父
    //utildate->sqldate  java.sq1.Date date1 = new java.sq1.Date(date.getTime( ));//Date date =new Date();
    @Test
    public void originTime(){

        long ltime = System.currentTimeMillis();
        System.out.println(ltime);
    }
}
