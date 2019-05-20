package com.csy.basic.java.relative.thread.create.test;

/**
 * 第一种线程创建方式，继承Thread类
 * @author chensy
 * @date 2019-05-19 22:18
 */
public class FirstCreate extends Thread {
    public static void main(String[] args) {
        FirstCreate thread = new FirstCreate();
        thread.start();
        //thread.run();
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("main" + ": " + i);
        }
        FirstCreate thread2 = new FirstCreate();
        //thread2.run();
        thread2.start();
        // thread.start(); //start是启动一个新线程，同一个线程只能调用一次

//        FirstCreate thread2 = new FirstCreate();
//        thread2.run();
//        thread2.run(); //一个线程可以多次调用run
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println(this.getName() + "：" + i);
        }
    }

    /**
     * 直接调用thread中的run，是按顺序进行的，没有实现多线程
     * Thread-0：0
     * Thread-0：1
     * Thread-0：2
     * main: 0
     * main: 1
     * main: 2
     * Thread-1：0
     * Thread-1：1
     * Thread-1：2
     */

    /**
     * 调用Thread中的start，线程调度交由JVM
     * 当线程获取到时间片就会调用run方法，并进行线程切换，实现了多线程，所以结果是并发执行，顺序是不确定的
     * Thread-0：0
     * main: 0
     * Thread-0：1
     * main: 1
     * Thread-0：2
     * main: 2
     * Thread-1：0
     * Thread-1：1
     * Thread-1：2
     */
}
