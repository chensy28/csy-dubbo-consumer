package com.csy.basic.java.relative.future.fromweb;

/**
 * @author chensy
 * @date 2019-05-17 22:56
 */
public class Client {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Server server = new Server();
        FutureData<String> futureData = server.getString();

        //先执行其他操作
        String hello = "hello";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(hello + " " + futureData.getData() + ",耗时 " + (System.currentTimeMillis() - start) / 1000);
    }
}
