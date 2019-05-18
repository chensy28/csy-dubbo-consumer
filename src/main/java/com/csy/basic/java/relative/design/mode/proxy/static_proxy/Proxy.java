package com.csy.basic.java.relative.design.mode.proxy.static_proxy;

/**
 * @author chensy
 * @date 2019-05-18 10:33
 *
 * 代理角色
 *
 */
public class Proxy implements Callable {

    Callable callable;

    public Proxy(Callable callable) {
        this.callable = callable;
    }

    public void call() {
        System.out.println("before...");  //在执行目标对象的目标方法前执行
        callable.call();
        System.out.println("after...");   //在执行目标对象的目标方法后执行
    }

    @Override
    public void test() {

    }

}
