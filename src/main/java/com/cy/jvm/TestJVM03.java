package com.cy.jvm;

public class TestJVM03 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//返回CPU核数
        long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机最大内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机的内存总量
        System.out.println("-Xms:MAX_MOMEORY="+maxMemory+"字节"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("-Xms:TOTAL_MOMEORY="+totalMemory+"字节"+(totalMemory/(double)1024/1024)+"MB");
        //生产环境下初始内存  最大内存必须一样
    }

}
