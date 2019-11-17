package com.cy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool01 {
    public static void main(String[] args) {
       ExecutorService threadPool =
                Executors.newFixedThreadPool( 5 );//一个线程池五个线程
     // ExecutorService threadPool =
       //         Executors.newSingleThreadExecutor(  );//一线程一个池
        //ExecutorService threadPool =Executors.newCachedThreadPool();//可以扩容线程池

           try {
                    //模拟有10个顾客模拟去银行办理业务,池子中有5个工作人员提供服务
               for (int i = 0; i <10 ; i++) {
                   TimeUnit.SECONDS.sleep( 1);
                   threadPool.execute( ()->{
                       System.out.println(Thread.currentThread().getName()+"\t办理业务");
                   } );

               }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    threadPool.shutdown();//用完关闭线程池
                }

    }
}
