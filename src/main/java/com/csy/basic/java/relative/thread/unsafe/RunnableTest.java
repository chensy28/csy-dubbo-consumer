package com.csy.basic.java.relative.thread.unsafe;

/**
 * @author chensy
 * @date 2019-05-27 18:56
 */
public class RunnableTest implements Runnable {
    private int count = 50;
    @Override
    public void run() {
       while (true) {
         if (count > 0) {
             System.out.println("值：" + count);
         }
       }
    }
}
