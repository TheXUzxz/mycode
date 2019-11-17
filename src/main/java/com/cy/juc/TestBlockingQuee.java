package com.cy.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//阻塞队列
public class TestBlockingQuee {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue  = new ArrayBlockingQueue(3  );
//        System.out.println(blockingQueue.add( "a" ));添加入队列
//        System.out.println(blockingQueue.add( "b" ));
//        System.out.println(blockingQueue.add( "c" ));
//        System.out.println(blockingQueue.add( "d" ));
//        System.out.println( blockingQueue.remove() );//先进先出
//        System.out.println( blockingQueue.remove() );
//        System.out.println( blockingQueue.remove() );
//        System.out.println( blockingQueue.remove() );
//        System.out.println(blockingQueue.add( "a" ));
//        System.out.println(blockingQueue.add( "b" ));
//        System.out.println(blockingQueue.element());获取队首
//        System.out.println(blockingQueue.offer( "a" ));
//        System.out.println(blockingQueue.offer( "b" ));
//        System.out.println(blockingQueue.offer( "c" ));
//     //   System.out.println(blockingQueue.offer( "d" ));
//        System.out.println( blockingQueue.poll() );
//        System.out.println( blockingQueue.poll() );
//        System.out.println( blockingQueue.poll() );
//        System.out.println( blockingQueue.poll() );//多余返回null

//        blockingQueue.put( "a" );
//        blockingQueue.put( "a" );
//        blockingQueue.put( "a" );
//       // blockingQueue.put( "a" );//put超过了阻塞
//        System.out.println( blockingQueue.take() );
//        System.out.println( blockingQueue.take() );
//        System.out.println( blockingQueue.take() );
//        System.out.println( blockingQueue.take() );
        System.out.println(blockingQueue.offer( "a" ));
        System.out.println(blockingQueue.offer( "b" ));
        System.out.println(blockingQueue.offer( "c" ));
        System.out.println(blockingQueue.offer( "a",3L,TimeUnit.SECONDS ));

    }

}
