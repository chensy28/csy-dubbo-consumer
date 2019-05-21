package com.csy.basic.java.relative.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor 创建方式
 * @author chensy
 * @date 2019-05-20 08:58
 */
public class SingleTest {
    public static void main(String[] args) {
        // 创建一个单线程的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 创建线程
        Thread t1 = new SingleThread();
        Thread t2 = new SingleThread2();
        Thread t3 = new SingleThread3();
        // 将线程放入池中进行执行,执行顺序是按给定的数据执行的
        pool.execute(t3);
        pool.execute(t1);
        pool.execute(t2);

        // 关闭线程池
        pool.shutdown();
    }

}

//创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务
//。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。

class SingleThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 111 正在执行。。。");
    }
}

class SingleThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 222 正在执行。。。");
    }
}

class SingleThread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 333 正在执行。。。");
    }
}

