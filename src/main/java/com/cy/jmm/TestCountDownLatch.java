package com.cy.jmm;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args)throws  Exception {
        //closeDoor();

        CountDownLatch countDownLatch = new CountDownLatch( 6 );
        for (int i = 1; i <=6 ; i++) {
            new Thread( ()->{
                System.out.println(Thread.currentThread().getName()+"\t 国,被灭");
                countDownLatch.countDown();
            },CountryEnum.forE( i ).getRetMessage() ).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 秦,统一六国");
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch( 6 );
        for (int i = 1; i <=6 ; i++) {
            new Thread( ()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习,离开教室");
                countDownLatch.countDown();
            },String.valueOf( i ) ).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门");
    }
}
