package com.csy.basic.java.relative.thread.pool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool 创建方式
 * @author chensy
 * @date 2019-05-20 09:04
 */
public class ScheduleTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
            @Override
            public void run() {
                //throw new RuntimeException();
                System.out.println("================");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

    }

}
