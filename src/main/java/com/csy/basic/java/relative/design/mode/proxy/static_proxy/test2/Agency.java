package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test2;

/**
 * @author chensy
 * @date 2019-05-18 21:34
 */
public class Agency implements Ticket {
    private RealObj realObj;

    public Agency(RealObj realObj) {
        this.realObj = realObj;
    }
    @Override
    public int buyTicket(double price) {
        System.out.println("调用目标对象前");
        int value = realObj.buyTicket(price);
        System.out.println("调用目标对象后");
        return value;
    }
}
