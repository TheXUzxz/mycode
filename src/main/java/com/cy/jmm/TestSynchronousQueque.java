package com.cy.jmm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
//同步队列,生产一个消费一个
public class TestSynchronousQueque {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>(  );
        new Thread( ()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put( "1" );
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put( "2" );
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put( "3" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA" ).start();
        new Thread( ()->{
            try {
                try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());


                try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());


                try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            }catch (Exception e){
                e.printStackTrace();
            }

        },"BB" ).start();
    }
}
