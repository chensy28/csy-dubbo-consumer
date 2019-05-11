package com.csy.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.csy.dubbo.provider.DemoService;
import com.csy.dubbo.provider.DemoServiceV2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

/**
 * 异步调用
 * @author chensy
 * @date 2019-05-11 08:23
 */
public class AsynInvoke {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
                {"classpath:consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

        //TODO dubbo各版本的异步调用 待解决
//        String hello = demoService.sayHello("world"); // 执行远程方法
//        System.out.println( hello ); // 显示调用结果

        // 2.7.0 以上的异步调用，本地引用不到2.7.0是不是，git下载有问题
//        // 此调用会立即返回null
//        demoService.sayHello("world");
//       // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
//        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
//        // 为Future添加回调
//        helloFuture.whenComplete((retValue, exception) -> {
//            if (exception == null) {
//                System.out.println(retValue);
//            } else {
//                exception.printStackTrace();
//            }
//        });


        /** 2.7 以前的版本调用*/
        // 异步非阻塞调用，一开始只是发出请求，不等待结果，继续往下执行，所以一开始为NULL
        // 若是同步调用，则会阻塞，等待第一步执行完，才能继续第二部
        System.out.println(demoService.sayHello("aync Hello"));
        // 获取上下文中的future，需要紧跟异步调用的service
        Future<String> future = RpcContext.getContext().getFuture();

        System.out.println(demoService.sayHaHa("yy"));
        DemoServiceV2 demoServiceV2 = (DemoServiceV2) context.getBean("demoServiceV2");
        System.out.println(demoServiceV2.sayHelloV2("testV2"));

        // 需要拿结果时，使用future调用get再阻塞获取结果
        String result = future.get();
        System.out.println(result);


        System.in.read(); // 按任意键退出
    }
}
