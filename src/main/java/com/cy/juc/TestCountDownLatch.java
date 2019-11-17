package com.cy.juc;

import java.util.concurrent.CountDownLatch;

//测试线程调度,控制线程顺序
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch( 6 );
        for (int i = 0; i < 6; i++) {
            new Thread( ()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"离开教室");
                countDownLatch.countDown();//计数
            },String.valueOf( i ) ).start();
        }
        countDownLatch.await();//阻塞当前线程
        System.out.println(Thread.currentThread().getName()+"\t"+"班长关门");


    }

    private static void closeDoor() {
        for (int i = 0; i < 6; i++) {
            new Thread( ()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"离开教室");
            },String.valueOf( i ) ).start();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"班长关门");
    }
}
