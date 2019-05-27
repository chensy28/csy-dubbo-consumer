package com.csy.dubbo.consumer.xml.test;

import com.csy.dubbo.provider.api.test.ApiDemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chensy
 * @date 2019-05-26 00:59
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
                {"classpath:consumer.xml"});
        context.start();
        ApiDemo apiDemo = (ApiDemo) context.getBean("apiDemo"); // 获取远程服务代理
        System.out.println("api:" + apiDemo.sayHello("xml test"));
        System.in.read(); // 按任意键退出
    }
}
