package com.cy.jmm;

import java.util.concurrent.*;

public class TestThreadPoolExcutor01 {
    public static void main(String[] args)throws Exception {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool =
                new ThreadPoolExecutor(
                        2,
                        5,
                        1L,
                        TimeUnit.SECONDS ,
                        new LinkedBlockingQueue<Runnable>( 3 ),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardPolicy() );
        for (int i = 0; i < 9; i++) {


            threadPool.execute( ()->{
                System.out.println(Thread.currentThread().getName()+"\t 办理业务");
            } );
        }

    }
}
