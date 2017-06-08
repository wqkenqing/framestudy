package com.thread;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Created by wqkenqing on 2017/5/16.
 */
public class ThreadTest extends Thread {
    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    private String threadName;


    public ThreadTest(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        super.run();
        System.out.println(this.threadName);
        for (int i=0;i<9;i++) {
            System.out.println("这是"+this.threadName+"第" + i + "次执行");
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("ok");
        ThreadTest threadTest1 = new ThreadTest("threadTest1");
        ThreadTest threadTest2 = new ThreadTest("threadTest2");
        threadTest1.start();
        threadTest2.start();

    }
}
