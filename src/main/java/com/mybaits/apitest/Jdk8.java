package com.mybaits.apitest;

import com.mybaits.funcinter.Addable;
import com.mybaits.funcinter.Eatable;
import com.mybaits.funcinter.Flyable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * @className:Jdk8
 * @author:wqkenqing
 * @describe:jdk8的api学习
 * @date:2017/3/20
 **/
public class Jdk8 {
    static String weather;

    void eat(Eatable e) {
        System.out.println("吃饭了");
        e.taste();
    }

    void fly(Flyable f) {
        f.drive(weather);
    }

    void test(Addable a) {
        System.out.println("5与3的和为8");
    }

    public static void main(String[] args) {
        Runnable oldThread = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is oldThread");
            }
        };
        Runnable newThread = () -> {
            System.out.println("this is newThread");
        };
        Thread thread = new Thread(oldThread);
        Thread thread1 = new Thread(() -> {
            System.out.println("this is new Thread");
        });
        thread.start();
        thread1.start();
    }
}
