package com.csy.basic.java.relative.design.mode.proxy.static_proxy;

/**
 * @author chensy
 * @date 2019-05-18 10:32
 *
 * 目标角色
 *
 */
public class Target implements Callable {

    public void call() {
        System.out.println("call...");
    }

    @Override
    public void test() {

    }

}
