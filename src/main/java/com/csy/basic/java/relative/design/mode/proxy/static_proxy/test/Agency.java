package com.csy.basic.java.relative.design.mode.proxy.static_proxy.test;

/**
 * 代售点
 * @author chensy
 * @date 2019-05-18 13:58
 */
public class Agency implements TrainTicket {
    private double servicePrice;  //服务费
    //private double unitPrice; //单价

    private RailywayStation railywayStation;

    public Agency(double servicePrice) {
        this.servicePrice = servicePrice;
       // this.unitPrice = unitPrice;
    }

    @Override
    public int buyTicket(double price) {
        /**
         * 此处不应该把计算逻辑放在代理上，代售点不应该管具体的计算方式，交由火车站计算，所以要持有目标对象的引用
         */
        //return new Double((price - servicePrice) / unitPrice).intValue();

        /**
         * 逻辑处理交由目标对象
         */
        return railywayStation.buyTicket(price - servicePrice);
    }

    public RailywayStation getRailywayStation() {
        return railywayStation;
    }

    public void setRailywayStation(RailywayStation railywayStation) {
        this.railywayStation = railywayStation;
    }

}
