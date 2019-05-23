package com.csy.basic.java.relative.future.fromweb;

/**
 * @author chensy
 * @date 2019-05-17 22:56
 */
public class Server {
    public FutureData<String> getString() {
        final FutureData<String> data = new FutureData<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.setData("world");
            }
        }).start();

        return data;
    }
}
