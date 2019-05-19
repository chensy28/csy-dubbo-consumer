package com.csy.basic.java.relative.design.mode.proxy.cglib.test;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @author chensy
 * @date 2019-05-18 23:42
 */
public class Test {
    public static void main(String[] args) throws Exception{
        TicketBuy target = new TicketBuy();
        ProxyFactory proxy = new ProxyFactory(target);
        // 获取代理对象
        TicketBuy ticketBuy = (TicketBuy) proxy.getProxyInstance();
        System.out.println(ticketBuy.buyTicket(150));

        // 为啥看不到动态代理对象
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/chenshengyong/Desktop");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.in.read();
    }
}
