package com.cy.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//       int corePoolSize,  线程池的核心线程数
//        int maximumPoolSize, 线程池中可以容纳的对打线程数,必须大于1
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory,
//        RejectedExecutionHandler handler
public class TestThreadPoolExecutor {

    public static void main(String[] args)
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService  threadPool = new
                ThreadPoolExecutor(
                        2,
                        5,
                        2L,
                    TimeUnit.SECONDS,
                new LinkedBlockingQueue<>( 3 ),
                Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.AbortPolicy(  )
        );
        try {
            //模拟有10个顾客模拟去银行办理业务,池子中有5个工作人员提供服务
            for (int i = 0; i <10 ; i++) {
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
