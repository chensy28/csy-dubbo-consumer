package com.csy.basic.java.relative.thread.create.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程的第三中创建方式 Callable + FutureTask(或Future)
 * @author chensy
 * @date 2019-05-19 23:56
 */
public class ThirdCreate implements Callable {
    @Override
    public Object call() throws Exception {  //相比runnable中的run，多了返回值，Callable还能取消任务
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            sum = sum + i;
            System.out.println("计算值:" + sum);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ThirdCreate thirdCreate = new ThirdCreate();
        FutureTask task = new FutureTask(thirdCreate); //创建一个 FutureTask ，它将在运行时执行给定的 Callable 。
        new Thread(task).start(); //用Thread来代理FutureTask对象
        for (int j = 0; j < 10; j++) {
            Thread.sleep(1000);
            System.out.println("main:" + j);
        }
        System.out.println(task.get()); // 等待计算完成，然后检索其结果
    }
}
