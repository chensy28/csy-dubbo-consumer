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

public class CountDownLatchTest1 implements Runnable{
    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;

    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        try {
            if (!bol) {
                System.out.println(bol);
                bol = true;
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("并发数量为" + number.intValue());
    }



public static void main(String[] args) {
        ExecutorService pool = Executors. newCachedThreadPool();
        CountDownLatchTest1 test = new CountDownLatchTest1();
        for (int i=0;i<10;i++) {
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