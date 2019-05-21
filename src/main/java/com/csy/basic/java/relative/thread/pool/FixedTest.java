package com.csy.basic.java.relative.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool 创建方式
 * @author chensy
 * @date 2019-05-20 08:56
 */
public class FixedTest {
        public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池（ThreadPoolExecutor向上转型到ExecutorService，ExecutorService是部分子类）
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 创建线程
        Thread t1 = new FixedThread1();
        t1.setName("aa");
        Thread t2 = new FixedThread2();
        t2.setName("bb");
        Thread t3 = new FixedThread3();
        t3.setName("cc");
        Thread t4 = new FixedThread4();
        t4.setName("dd");
        Thread t5 = new FixedThread5();
        t5.setName("ee");
        Thread t6 = new FixedThread5();
        t6.setName("gg");
        Thread t7 = new FixedThread5();
        t7.setName("hh");
        // 用new创建5个线程
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        // 将线程放入池中进行执行，复用线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        // 关闭线程池
        pool.shutdown();
    }

}

class FixedThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 固定大小11 正在执行。。。");
    }
}

class FixedThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 固定大小22 正在执行。。。");
    }
}

class FixedThread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 固定大小33 正在执行。。。");
    }
}

class FixedThread4 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 固定大小44 正在执行。。。");
    }
}

class FixedThread5 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 固定大小55 正在执行。。。");
    }
}

/**
 * 线程池参数
 * core size
 * max  size
 * queue size
 */

