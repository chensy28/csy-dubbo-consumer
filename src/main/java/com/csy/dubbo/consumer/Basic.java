package com.csy.dubbo.consumer;

import com.csy.dubbo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chensy
 * @date 2019-04-29 08:23
 */
public class Basic {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
                {"classpath:consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

        demoService.sayHello("aync Hello");
        System.in.read(); // 按任意键退出
    }
}
