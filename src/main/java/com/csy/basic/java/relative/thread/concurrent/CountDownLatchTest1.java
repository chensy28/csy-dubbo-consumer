package com.csy.basic.java.relative.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 模拟高并发
 *
 * @author chensy
 * @date 2019-05-27 16:59
 */

public class CountDownLatchTest1 implements Runnable {
    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;
    private static int num = 0;

    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this) { //所有请求都阻塞在此处，第一个线程进入以后，又持者锁睡眠5秒，一旦锁解除，全部线程就同时进行
            try {
                if (!bol) {
                    System.out.println(bol);
                    bol = true;
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("并发数量为" + number.intValue() + ", 统计总量：" + (num++));
        }
    }



    public static void main(String[] args) {
        ExecutorService pool = Executors. newCachedThreadPool();
        CountDownLatchTest1 test = new CountDownLatchTest1();
        for (int i = 0; i < 10; i++) {
            pool.execute(test);
        }
    }
}


/**
 * 1.关于线程池的“惊群效应"
 * https://blog.csdn.net/tuantuanls/article/details/41205739
 *
 * 2.JAVA 模拟瞬间高并发
 * https://blog.csdn.net/zhao9tian/article/details/40346899
 */