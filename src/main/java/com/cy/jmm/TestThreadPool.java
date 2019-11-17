package com.cy.jmm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *      为什么要用线程池
 *          优势:降低资源消耗,通过重复利用自己创建的线程降低线程的创建和销毁造成的消耗
 *              提高响应速度,当任务到达时,任务可以不需要的等到线程创建就能立即执行
 *               提高线程的可管理性
 *
 * */
public class TestThreadPool {
    public static void main(String[] args) {
       // System.out.println( Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool=
                Executors.newFixedThreadPool(5  );//一池固定线程
        ExecutorService threadPool1=Executors.newSingleThreadExecutor();//一池一线程

        ExecutorService threadPool2 =Executors.newCachedThreadPool();//一池多线程,可扩容
        try {
            for (int i = 0; i < 10; i++) {
                threadPool2.submit( ()->{
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务" );
                    // try{    TimeUnit.MILLISECONDS.sleep( 200 );}catch (Exception e){}
                } );
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
