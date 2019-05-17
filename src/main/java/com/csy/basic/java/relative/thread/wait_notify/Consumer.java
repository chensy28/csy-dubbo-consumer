package com.csy.basic.java.relative.thread.wait_notify;

/**
 * @author chensy
 * @date 2019-05-17 23:39
 */
public class Consumer extends Thread {

    private Producer producer;

    public Consumer(String name, Producer producer) {
        super(name);
        this.producer = producer;
    }

    @Override public void run() {
        while (true) {
            Message msg = producer.waitMsg();
            System.out.println("Consumer " + getName() + " get a msg");
        }
    }

    public static void main(String[] args) {
        Producer p = new Producer();
        p.start();
        new Consumer("Consumer1", p).start();
        new Consumer("Consumer2", p).start();
        new Consumer("Consumer3", p).start();
    }
}

