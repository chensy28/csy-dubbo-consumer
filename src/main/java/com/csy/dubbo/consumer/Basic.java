package com.csy.dubbo.consumer;

import com.csy.dubbo.provider.DemoService;
import com.csy.dubbo.provider.DemoServiceV2;
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
        DemoServiceV2 demoServiceV2 = (DemoServiceV2) context.getBean("demoServiceV2"); // 获取远程服务代理
        long curTime = System.currentTimeMillis();
        demoServiceV2.sayHelloV2("aync Hello");
        System.out.println("消耗时间:" + (System.currentTimeMillis() - curTime));
        System.in.read(); // 按任意键退出
    }
}