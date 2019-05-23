package com.csy.basic.java.relative.thread.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensy
 * @date 2019-05-17 23:38
 *
 * java中的wait、notify、notifyAll
 * https://www.jianshu.com/p/f7d4819b7b24
 *
 *
 */
public class Producer extends Thread {

    List<Message> msgList = new ArrayList<Message>();

    //  Object的wait与notify/notifyAll的时候，必须保证调用代码对该Object是同步的，也就是说必须在作用等同于synchronized(obj){......}的内部
    //  才能够去调用obj的wait与notify/notifyAll三个方法
    //  java.lang.IllegalMonitorStateException
    @Override public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                Message msg = new Message();
                synchronized(msgList) {
                    msgList.add(msg);
                    msgList.notify(); //这里只能是notify而不能是notifyAll，否则remove(0)会报java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * wait：线程自动释放其占有的对象锁，并等待notify
     * notify：唤醒一个正在wait当前对象锁的线程，并让它拿到对象锁
     * notifyAll：唤醒所有正在wait前对象锁的线程
     *
     * notify和notifyAll的最主要的区别是：notify只是唤醒一个正在wait当前对象锁的线程，而notifyAll唤醒所有。值得注意的是：notify是本地方法，
     * 具体唤醒哪一个线程由虚拟机控制；notifyAll后并不是所有的线程都能马上往下执行，它们只是跳出了wait状态，接下来它们还会是竞争对象锁。
     *
     */
    public Message waitMsg() {
        synchronized(msgList) { //synchronized的机制保证了同一时间最多只能有1个线程拿到了对象的锁
            if(msgList.size() == 0) {
                try {
                    msgList.wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return msgList.remove(0);
        }
    }
}

