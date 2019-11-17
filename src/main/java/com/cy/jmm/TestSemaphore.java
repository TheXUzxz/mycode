package com.cy.jmm;
//信号灯的主要用的两个目的,一个是用于多线程共享资源互斥使用,
// 另一个是用于并发线程数的控制

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore( 3 );//3个车位
        for (int i = 0; i <6 ; i++) {//6个车
            new Thread( ()->{
                try {
                    semaphore.acquire();//抢车位
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                     try{    TimeUnit.SECONDS.sleep( 3 );}catch (Exception e){}
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放车位
                }
            },String.valueOf( i ) ).start();
        }


    }
}
