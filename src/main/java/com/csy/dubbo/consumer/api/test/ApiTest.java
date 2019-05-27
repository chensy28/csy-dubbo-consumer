package com.csy.dubbo.consumer.api.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.csy.dubbo.provider.api.test.ApiDemo;

/**
 * @author chensy
 * @date 2019-05-25 23:31
 */
public class ApiTest {
    public static void main(String[] args) throws Exception {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("csy_dubbo2");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("127.0.0.1");
        registry.setPort(2181);
        //需要指定注册中心端口
//        registry.setAddress("127.0.0.1:2181");
        //需要指定注册协议
        registry.setProtocol("zookeeper");

        ReferenceConfig<ApiDemo> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(ApiDemo.class);
        reference.setVersion("1.0.0"); //若填了版本号，应该与提供者版本号一致

        ApiDemo apiDemo = reference.get();
        System.out.println("消费者：" + apiDemo.sayHello("consumer2345"));
        System.in.read();

    }
    /**
     * spring容器组成之FactoryBeanRegistrySupport(工厂bean，xml配置的是普通bean)
     * https://www.jianshu.com/p/5edf22cc4e06
     *
     */

}
