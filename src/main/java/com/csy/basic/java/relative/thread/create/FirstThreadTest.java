package com.csy.basic.java.relative.thread.create;

/**
 * 创建线程的四种方式
 * 1. 继承Thread类创建线程类
 * @author chensy
 * @date 2019-05-18 00:00
 */
public class FirstThreadTest extends Thread {
    int i = 0;
    //重写run方法，run方法的方法体就是现场执行体
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if(i == 20) {
                new FirstThreadTest().run();
                new FirstThreadTest().run();
            }
        }
    }

}
