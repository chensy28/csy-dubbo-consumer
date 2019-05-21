package com.csy.basic.java.relative.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool 创建方式
 * @author chensy
 * @date 2019-05-20 09:00
 */
public class CachedTest {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 创建线程
        Thread t1 = new MyThread3();
        Thread t2 = new MyThread3();
        Thread t3 = new MyThread3();
        Thread t4 = new MyThread3();
        Thread t5 = new MyThread3();
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}

