package com.csy.basic.java.relative.thread.create.debug;

import java.util.concurrent.TimeUnit;

/**
 * 实现多线程调试debug
 *
 * 在断点上直接右键设置，把All改为Thread，然后就会在每个线程的断点都会停留
 * @author chensy
 * @date 2019-05-18 10:03
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }

    }
}
