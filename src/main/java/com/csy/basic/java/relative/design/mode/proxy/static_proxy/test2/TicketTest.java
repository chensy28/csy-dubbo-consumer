package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test2;

/**
 * @author chensy
 * @date 2019-05-18 21:36
 */
public class TicketTest {
    public static void main(String[] args) {
        RealObj realObj = new RealObj();
        Agency agency = new Agency(realObj);
        System.out.println(agency.buyTicket(150));
    }
}
