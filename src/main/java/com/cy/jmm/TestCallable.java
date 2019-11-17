package com.cy.jmm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("com in Callable");
         try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
        return 1024;
    }
}
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask =
                new FutureTask<>( new MyThread() );//适配器模式'

//        FutureTask<Integer> futureTask2 =
//                new FutureTask<>( new MyThread() );//适配器模式
        Thread t1  = new Thread( futureTask,"AAA" );
        t1.start();
        new Thread( futureTask,"BB" ).start();
        System.out.println(Thread.currentThread().getName()+"*********************************");
        int result1=100;
        while (!futureTask.isDone()){

        }
        int result2=futureTask.get();
       //如无必要,建议放在最后//要求获得Callable线程的计算结果,如果没有计算完成就要去强求,可能会导致阻塞,直到计算完成
        System.out.println("******"+(result1+result2));

    }
}
