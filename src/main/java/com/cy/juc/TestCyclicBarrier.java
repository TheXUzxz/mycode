package com.cy.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//计数+
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier( 7,()->{
            System.out.println("召唤神龙");
        } );
        for (int i = 1; i <=7 ; i++) {
            final int  tempInt = i;
            new Thread( ()->{

                System.out.println(Thread.currentThread().getName()+"\t收集到了第:"+tempInt+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"name" ).start();
        }
    }

}
