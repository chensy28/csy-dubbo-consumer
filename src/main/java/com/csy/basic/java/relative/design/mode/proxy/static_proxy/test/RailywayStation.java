package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test;

/**
 * 火车站
 * @author chensy
 * @date 2019-05-18 13:51
 */
public class RailywayStation implements TrainTicket {
    private double unitPrice; //单价

    public RailywayStation(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int buyTicket(double price) {
        return new Double(price / unitPrice).intValue();
    }
}
