package com.csy.basic.java.relative.future.fromweb;

/**
 * @author chensy
 * @date 2019-05-17 22:54
 *
 */
public class FutureData<T> {
    private boolean mIsReady = false;
    private T mData;

    public synchronized void setData(T data) {
        mIsReady = true;
        mData = data;

        notifyAll();
    }

    public synchronized T getData() {
        while (!mIsReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mData;
    }
}

