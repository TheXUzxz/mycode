package com.cy.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//异步回调
public class TestCompletableFuture {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture= CompletableFuture.runAsync( ()->{
            System.out.println(Thread.currentThread().getName()+"没有返回: update mysql ok");
        } );
        completableFuture.get();
        //有返回值
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync( () -> {
            System.out.println( Thread.currentThread().getName() + "有返回: insert mysql ok" );
           //int i=1/0;
            return 1024;
        } );
        integerCompletableFuture.whenComplete( (t, u) -> {
            System.out.println( "ttttt:" + t );//正常输出1024   异常输出:null
            System.out.println( "uuuu:" + u );//正常输出null      异常输出异常信息
        } ).exceptionally( f -> {
            System.out.println( "exception:" + f.getMessage() );
            return 444;
        } ).get() ;

    }
}
