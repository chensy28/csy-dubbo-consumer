package com.csy.basic.java.relative.network.sslsocket;

import java.io.File;

/**
 * @author chensy
 * @date 2019-05-24 15:11
 */
public class Test {
    public static void main(String[] args) {
        //2、使用File提供的函数获取当前路径：
        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){}
    }
}
