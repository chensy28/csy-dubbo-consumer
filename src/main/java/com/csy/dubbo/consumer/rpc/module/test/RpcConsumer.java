package com.csy.dubbo.consumer.rpc.module.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.csy.dubbo.provider.rpc.module.test.RpcDemo;

/**
 * @author chensy
 * @date 2019-05-28 23:37
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("rpc_module");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("localhost:2181");
        registry.setProtocol("zookeeper");

//        ProtocolConfig protocol = new ProtocolConfig();
//        protocol.setName("dubbo");
//        protocol.setPort(20880);

        ReferenceConfig reference = new ReferenceConfig();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setProtocol("dubbo");
        reference.setInterface(RpcDemo.class); //interface必须指定

        RpcDemo rpcDemo = (RpcDemo) reference.get();
        System.out.println(rpcDemo.sayHi("haha"));

        System.in.read();
    }
}
