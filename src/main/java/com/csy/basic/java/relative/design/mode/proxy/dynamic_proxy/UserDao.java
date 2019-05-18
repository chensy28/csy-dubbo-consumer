package com.csy.basic.java.relative.design.mode.proxy.dynamic_proxy;

/**
 * 目标对象
 * @author chensy
 * @date 2019-05-18 12:21
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
