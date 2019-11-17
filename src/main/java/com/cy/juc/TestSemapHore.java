package com.cy.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//信号灯   用于多线程并发的控制
public class TestSemapHore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore( 3 );//模拟资源类,有三个空车位
        for (int i = 0; i <6 ; i++) {
            new Thread( ()->{
                try {
                    semaphore.acquire();//抢到了资源-1
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
                    TimeUnit.SECONDS.sleep( 3 );
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf( i ) ).start();
        }
    }

}
