package com.mybaits.apitest;

import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wqkenqing on 2017/3/22.
 */
public class ThreadTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println(String.format("线程%s正在等待倒计时结束，当前时间：%s。", Thread.currentThread().getName(), LocalTime.now()));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("倒计时结束，当前时间：%s。", LocalTime.now()));
        }, "Thread-0").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("线程%s准备倒计时，当前时间：%s。", Thread.currentThread().getName(), LocalTime.now()));
            countDownLatch.countDown();
        }, "Thread-1").start();

        new Thread(() -> {
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("线程%s准备倒计时，当前时间：%s。", Thread.currentThread().getName(), LocalTime.now()));
            countDownLatch.countDown();
        }, "Thread-2").start();
    }
}
