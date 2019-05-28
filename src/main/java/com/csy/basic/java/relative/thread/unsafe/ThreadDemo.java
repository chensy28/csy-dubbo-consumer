package com.csy.basic.java.relative.thread.unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全Demo
 * @author chensy
 * @date 2019-05-27 17:46
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建票对象
        Ticket ticket = new Ticket();

        //创建3个窗口
        Thread t1  = new Thread(ticket, "窗口1");
        Thread t2  = new Thread(ticket, "窗口2");
        Thread t3  = new Thread(ticket, "窗口3");

//        t1.start();
//        t2.start();
//        t3.start();

        /**
         * 使用线程池，依然会出现线程不安全问题
         * 线程池只不过用来管理线程，合理分配资源而已
         *
         * 提交线程到线程池，可以用submit或execute
         * ExecutorService 中 submit 和 execute 的区别
         * https://hacpai.com/article/1493450244046
         *
         * submit传入的是Callable（有返回值），execute传入的是Runnable（无返回值）
         * submit能捕获提交线程的异常，而execute不能捕获提交线程的异常
         */
        ExecutorService service = Executors.newCachedThreadPool();
//        service.submit(t1);
//        service.submit(t2);
//        service.submit(t3);

        service.execute(t1);
        service.execute(t2);
        service.execute(t3);

    }
}
