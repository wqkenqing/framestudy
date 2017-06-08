package com.mybaits.apitest;

import com.mybaits.funcinter.Addable;
import com.mybaits.funcinter.Eatable;
import com.mybaits.funcinter.Flyable;

import java.awt.event.ActionListener;

/**
 * @className:Jdk8
 * @author:wqkenqing
 * @describe:jdk8的api学习
 * @date:2017/3/20
 **/
public class Jdk8_1 {

    public static void main(String[] args) {
//        Runnable d=()-> System.out.println(2+3);
        int a =2;
        int b=3;
        new Thread(() -> {
            System.out.println("a+b="+(a+b));
        }).start();
    }
}
