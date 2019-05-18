package com.csy.basic.java.relative.thread.create;

/**
 * 2. 通过Runable接口创建线程类，作为参数传入thread类，并调用start()方法启动
 * @author chensy
 * @date 2019-05-18 00:03
 */
public class RunnableThreadTest implements Runnable {
    private int i;
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                RunnableThreadTest rtt = new RunnableThreadTest();
                new Thread(rtt, "新线程1").start();
                new Thread(rtt, "新线程2").start();
            }
        }

    }

    /**
     * 设计模式：JDK静态代理之Thread/Runnable
     * https://blog.csdn.net/zhangzeyuaaa/article/details/41869221
     *
     *
     */

}

