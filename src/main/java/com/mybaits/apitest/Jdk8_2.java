package com.mybaits.apitest;

import com.mybaits.funcinter.Demo;
import com.mybaits.funcinter.LambdaTest;

/**
 * @className:Jdk8
 * @author:wqkenqing
 * @describe:jdk8的api学习
 * @date:2017/3/20
 **/
public class Jdk8_2 {

    public static void main(String[] args) {
        LambdaTest l=Integer::new;

        int a = l.stringParase("12");
        System.out.println(a);
    }
}
