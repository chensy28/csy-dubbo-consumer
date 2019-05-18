package com.csy.basic.java.relative.design.mode.proxy.cglib.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理工厂
 * @author chensy
 * @date 2019-05-18 23:40
 */
public class ProxyFactory  implements MethodInterceptor {
    private TicketBuy target; //维护一个目标对象

    public ProxyFactory(TicketBuy target) {
        this.target = target;
    }

    // 创建代理
    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass()); //此处不设置或设置错误，抛出java.lang.ClassCastException
        en.setCallback(this);  //此处不设置或设置错误，java.lang.NullPointerException
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("拦截前");
        Object value = method.invoke(target, objects);
        System.out.println("拦截后");
        return value;
    }
}
