package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test;

/**
 * 场景：通过代理售票处购买车票
 * @author chensy
 * @date 2019-05-18 14:02
 *
 * 静态代理：一个目标对象对应一个代理对象
 */
public class BuyTicketTest {
    public static void main(String[] args) {
        //直接访问目标对象，没通过代理
        RailywayStation railywayStation = new RailywayStation(50.00);
        System.out.println("购买车票数：" + railywayStation.buyTicket(102.00));


        //通过代理访问对象,持有目标对象的引用
        Agency agency = new Agency(16.00);
        RailywayStation target = new RailywayStation(50.00);
        agency.setRailywayStation(target);
        System.out.println(agency.buyTicket(106));
    }
}
