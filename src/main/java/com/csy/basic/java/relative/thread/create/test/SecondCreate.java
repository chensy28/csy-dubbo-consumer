package com.csy.basic.java.relative.thread.create.test;

/**
 * 第二种线程创建方式，实现runnable接口
 * @author chensy
 * @date 2019-05-19 23:17
 */
public class SecondCreate implements Runnable {
    @Override
    public void run() {
       for (int i = 0; i < 10; i++) {  //runnable中的异常只能内部消化，不能向外抛出
           try {
               Thread.sleep(1000);
               System.out.println(":" + i);
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
    }

    public static void main(String[] args) {
        SecondCreate target = new SecondCreate();
        Thread thread = new Thread(target);
        thread.start();
        //target.run();// 仅仅是普通方法的run调用，没有实现多线程

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("a:" + i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
