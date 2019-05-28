package com.csy.basic.java.relative.thread.unsafe;

/**
 * @author chensy
 * @date 2019-05-27 17:47
 */
public class Ticket implements Runnable {
    //共100票
    int ticket = 50;

    @Override
    public void run() {
        //模拟卖票
        while (true) {
            /**
             * 票数ticket可能出现负数的情况
             * 当多个线程同时经过 if (ticket > 0)时，比如两个线程都是1，那拿到数据就为-1，使用线程池也会出现-1
             */
            if (ticket > 0) {
                //模拟选坐的操作
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket--);
            }
        }
    }

    /**
     * Java之多线程安全性问题
     * https://blog.csdn.net/mmake1994/article/details/80533365
     *
     */
}
