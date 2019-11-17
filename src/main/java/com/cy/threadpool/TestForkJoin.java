package com.cy.threadpool;
//分支合并,把复杂的任务拆分

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 *
 * **/
class  MyTask extends RecursiveTask<Integer> {

    private static  final  Integer ADJUST_VALUE =10;
    private  int begin;
    private int end;
    private int result;
    public MyTask(int begin,int end){
        this.begin=begin;
        this.end=end;
    }

    @Override
    protected Integer compute() {

        if ((end-begin)<=ADJUST_VALUE){
            for (int i = begin; i <=end; i++) {
                result=result+i;
            }
        }else {
            int midle=(end+begin)/2;
            MyTask myTask =new MyTask( begin,midle );
            MyTask myTask2 =new MyTask( midle+1,end );
            myTask.fork();
            myTask2.fork();
            result =myTask.join()+myTask2.join();

        }

        return result;
    }
}
public class TestForkJoin {
    public static void main(String[] args)throws Exception {
        MyTask myTask = new MyTask( 0,100 );
        ForkJoinPool  threadPool = new ForkJoinPool(  );
        ForkJoinTask<Integer> forkJoin = threadPool.submit( myTask );
        System.out.println( forkJoin.get() );

        threadPool.shutdown();

    }


}
