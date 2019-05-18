package com.csy.basic.java.relative.design.mode.proxy.dynamic_proxy.test2;

/**
 * 目标对象
 * @author chensy
 * @date 2019-05-18 22:06
 */
public class TargeObj implements Ticket {
    @Override
    public int buyTicket(double price) {
        return new Double(price / 50).intValue();
    }
}
