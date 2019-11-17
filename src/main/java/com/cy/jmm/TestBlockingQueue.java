package com.cy.jmm;

//1.队列

import java.util.List;
import java.util.concurrent.*;

/**
 *
 *   ArrayBlockingQueue是一个基于数组结构的阻塞队列,此队列按FIFO(先进先出)原则对元素进行排序
 *   LinkedBlockingQueue一个基于链表结构的阻塞队列,此队列按FIFO(先进先出)排序元素,吞吐量高于ArrayBlockingQueue
 *   SynchronousQueue 一个不存储元素的阻塞队列,每个插入操作必须等到另一个线程调用移除操作
 *     否则插入操作一直处于阻塞状态吞吐量通常要高
 *     阻塞队列
 *      有没有好的一面
 *
 *      不得不阻塞如何管理
 *      好处,不需要关心什么时候阻塞线程,什么时候唤醒线程
 *
 * /usr/local/src/redis/cluster/7000
 *      * **/
public class TestBlockingQueue {
    public static void main(String[] args)throws  Exception {
        //tryE();
        //trueF();
        //put();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>( 3 );
        System.out.println( blockingQueue.offer( "a", 2L, TimeUnit.SECONDS ) );
        System.out.println( blockingQueue.offer( "b", 2L, TimeUnit.SECONDS ) );
        System.out.println( blockingQueue.offer( "c", 2L, TimeUnit.SECONDS ) );
        System.out.println( blockingQueue.offer( "d", 2L, TimeUnit.SECONDS ) );

    }

    private static void put() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>( 3 );
        blockingQueue.put( "a" );
        blockingQueue.put( "b" );
        blockingQueue.put( "c" );
        System.out.println("=====================");
        // blockingQueue.put( "d" );//队列满了一直阻塞


        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    private static void trueF() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>( 3 );
        System.out.println(blockingQueue.offer( "a" ));
        System.out.println(blockingQueue.offer( "b" ));
        System.out.println(blockingQueue.offer( "c" ));
        System.out.println(blockingQueue.offer( "d" ));
        System.out.println(blockingQueue.peek());//队首
        System.out.println(blockingQueue.poll(  ));
        System.out.println(blockingQueue.poll(  ));
        System.out.println(blockingQueue.poll(  ));
        System.out.println(blockingQueue.poll(  ));//没有返回NUll
    }

    private static void tryE() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>( 3 );
        System.out.println(blockingQueue.add( "a" ));
        System.out.println( blockingQueue.add( "b" ) );
        System.out.println( blockingQueue.add( "c" ) );
        System.out.println(blockingQueue.element());//返回队列队首元素
        //  System.out.println( blockingQueue.add( "b" ) );
        System.out.println(blockingQueue.remove(  ));
        System.out.println(blockingQueue.remove(  ));
        System.out.println(blockingQueue.remove(  ));
        //System.out.println(blockingQueue.remove(  ));
    }
}
