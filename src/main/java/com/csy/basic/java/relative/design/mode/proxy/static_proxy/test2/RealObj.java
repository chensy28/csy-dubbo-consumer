package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test2;

/**
 * @author chensy
 * @date 2019-05-18 21:35
 */
public class RealObj implements Ticket {
    private double unitPrice = 50;
    @Override
    public int buyTicket(double price) {
        return new Double(price / unitPrice).intValue();
    }
}
