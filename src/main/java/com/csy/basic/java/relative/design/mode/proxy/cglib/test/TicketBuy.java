package com.csy.basic.java.relative.design.mode.proxy.cglib.test;

/**
 * @author chensy
 * @date 2019-05-18 23:38
 */
public class TicketBuy {
    public int buyTicket(double price) {
        return new Double(price / 50).intValue();
    }
}
