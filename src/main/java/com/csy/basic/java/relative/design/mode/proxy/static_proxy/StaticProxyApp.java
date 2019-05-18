package com.csy.basic.java.relative.design.mode.proxy.static_proxy;

/**
 * @author chensy
 * @date 2019-05-18 10:33
 */
public class StaticProxyApp {
    public static void main(String[] args) {
        Callable target = new Target();  // 目标对象
        Callable proxy = new Proxy(target); // 代理对象，持有目标对象的引用
        proxy.call();
    }

    /**
     * 静态代理有如下要素：
     *
     * 1.目标角色（真实角色）。
     * 2.代理角色。
     * 3.目标角色和代理角色实现同一接口。
     * 4.代理角色持有目标角色的引用。
     */

    /**
     * Java三种代理模式：静态代理、动态代理和cglib代理
     * https://segmentfault.com/a/1190000011291179
     *
     * 代理模式是一种设计模式，提供了对目标对象额外的访问方式，即通过代理对象访问目标对象，这样可以在不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能。
     * 简言之，代理模式就是设置一个中间代理来控制访问原目标对象，以达到增强原对象的功能和简化访问方式。
     *
     * 例子：代售点代理了火车站对象，提供购买车票的方法
     *
     */

    /**
     *
     * 静态代理方式需要代理对象和目标对象实现一样的接口。
     *
     * 优点：可以在不修改目标对象的前提下扩展目标对象的功能。
     *
     * 缺点：
     * 冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
     * 不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
     */

}
