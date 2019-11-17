package com.cy.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come nihao");
        return 1024;
    }
}
public class TestCallble {
    public static void main(String[] args) {
        FutureTask<Integer>  futureTask = new FutureTask( new MyThread() );
        new Thread( futureTask,"name" ).start();
        try {
            Integer result =futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
