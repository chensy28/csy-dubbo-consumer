package com.csy.basic.java.relative.design.mode.proxy.cglib.test;

/**
 * @author chensy
 * @date 2019-05-18 23:42
 */
public class Test {
    public static void main(String[] args) {
        TicketBuy target = new TicketBuy();
        ProxyFactory proxy = new ProxyFactory(target);
        // 获取代理对象
        TicketBuy ticketBuy = (TicketBuy) proxy.getProxyInstance();
        System.out.println(ticketBuy.buyTicket(150));
    }
}
