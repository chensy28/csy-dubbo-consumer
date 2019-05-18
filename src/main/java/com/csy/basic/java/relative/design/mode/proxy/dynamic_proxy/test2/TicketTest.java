package com.csy.basic.java.relative.design.mode.proxy.dynamic_proxy.test2;

/**
 * @author chensy
 * @date 2019-05-18 22:07
 */
public class TicketTest {
    public static void main(String[] args) {
        TargeObj targeObj = new TargeObj();
        //创建代理
        ProxyFactory proxyFactory = new ProxyFactory(targeObj);
        //将代理对象转换到接口
        Ticket ticket = (Ticket) proxyFactory.getProxyInstance();
        System.out.println(ticket.buyTicket(150));
    }
}
