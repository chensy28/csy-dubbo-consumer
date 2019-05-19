package com.csy.basic.java.relative.design.mode.proxy.cglib;

/**
 * @author chensy
 * @date 2019-05-18 12:36
 */
public class TestProxy {
    public static void main(String[] args) throws Exception {
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
        System.in.read();
    }

    /**
     * cglib特点
     *
     * JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
     * 如果想代理没有实现接口的类，就可以使用CGLIB实现。
     * CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
     * 它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
     * CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
     * 不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
     * cglib与动态代理最大的区别就是
     *
     * 使用动态代理的对象必须实现一个或多个接口
     * 使用cglib代理的对象则无需实现接口，达到代理类无侵入。
     *
     * Cglib生成的代理类
     * class com.csy.basic.java.relative.design.mode.proxy.cglib.UserDao$$EnhancerByCGLIB$$be25ec98 @0x00000007c0073f88
     */
}
