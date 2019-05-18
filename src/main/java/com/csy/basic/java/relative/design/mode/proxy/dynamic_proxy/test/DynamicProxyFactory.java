package com.csy.basic.java.relative.design.mode.proxy.dynamic_proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK中的Proxy实现代理
 * 动态代理工厂
 * @author chensy
 * @date 2019-05-18 15:32
 */
public class DynamicProxyFactory {
    private Object target;
    private double servicePrice = 23; //服务费用
    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("调用前");
                //在调用目标对象的方法前进行业务处理
                args[0] = (double)args[0] - servicePrice;
                Object obj = method.invoke(target, args);
                System.out.println("调用后");
                return obj;
            }
        };
        //对目标对象实现代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
