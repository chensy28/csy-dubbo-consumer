package com.csy.basic.java.relative.network.sslsocket;

/**
 * Java使用SSLSocket通信
 * https://my.oschina.net/itblog/blog/651608
 *
 * SSL通信服务器端：
 * @author chensy
 * @date 2019-05-24 00:24
 */
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.TrustManagerFactory;

/**
 * java中 SSL认证和keystore使用
 * java中是通过SSL认证，使用的是SSLSocket，通过SSLSocketFactory可以获得SSLSocket实例对象。通常SSLSocketFactory需要一个SSLContext环境对象来构建，
 *
 * https://www.cnblogs.com/developer-ios/p/6267345.html
 */
public class SSLServer {
    private SSLServerSocket sslServerSocket;
    public static void main(String[] args) throws Exception {
        SSLServer server = new SSLServer();
        server.init();
        System.out.println("SSLServer initialized.");
        server.process();
    }

    //服务器端将要使用到server.keystore和ca-trust.keystore
    public void init() throws Exception {
        int port = 1234;
        String keystorePath = "/Users/chenshengyong/selfPro/dubbo_demo/consumer_demo/src/main/java/com/csy/basic/java/relative/network/sslsocket/server.keystore";
        String trustKeystorePath = "/Users/chenshengyong/selfPro/dubbo_demo/consumer_demo/src/main/java/com/csy/basic/java/relative/network/sslsocket/ca-trust.keystore";
        String keystorePassword = "123456";
        SSLContext context = SSLContext.getInstance("SSL");

        /**
         * 常用的Java Keytool Keystore命令
         * https://www.chinassl.net/ssltools/keytool-commands.html
         */
        //客户端证书库
        KeyStore keystore = KeyStore.getInstance("pkcs12");
        FileInputStream keystoreFis = new FileInputStream(keystorePath);
        keystore.load(keystoreFis, keystorePassword.toCharArray());
        //信任证书库
        KeyStore trustKeystore = KeyStore.getInstance("jks");
        FileInputStream trustKeystoreFis = new FileInputStream(trustKeystorePath);

        /**
         * 密码校验
         * java.io.IOException: keystore password was incorrect
         */
        trustKeystore.load(trustKeystoreFis, keystorePassword.toCharArray());

        //密钥库
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("sunx509");
        kmf.init(keystore, keystorePassword.toCharArray());

        //信任库
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
        tmf.init(trustKeystore);

        //初始化SSL上下文
        context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        //初始化SSLSocket
        sslServerSocket = (SSLServerSocket)context.getServerSocketFactory().createServerSocket(port);
        //设置这个SSLServerSocket需要授权的客户端访问
        sslServerSocket.setNeedClientAuth(true);
    }

    public void process() throws Exception {
        String bye = "Bye";
        byte[] buffer = new byte[50];
        while(true) {
            Socket socket = sslServerSocket.accept();
            InputStream in = socket.getInputStream();
            in.read(buffer);
            System.out.println("Received: " + new String(buffer));
            OutputStream out = socket.getOutputStream();
            out.write(bye.getBytes());
            out.flush();
        }
    }
}

