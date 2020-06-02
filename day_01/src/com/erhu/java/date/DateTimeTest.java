package com.erhu.java.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeTest {
    @Test
    public void test(){
        long l = System.currentTimeMillis();
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        System.out.println(l);
        System.out.println(date.toString());
        //LocalDateTime不可变
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.withHour(1));//设置小时
        System.out.println(localDateTime.plusHours(2));//增加两小时
        System.out.println(localDateTime.minusHours(1));//减一小时

    }
}
