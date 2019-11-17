package com.cy.jmm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class  MyResource{
    private volatile boolean falg=true;//默认开启,进行生产和消费
    private AtomicInteger atomicInteger = new AtomicInteger(  );//默认为0
    BlockingQueue<String> blockingQueue = null;//尽量使用接口

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());//查看传的是谁
    }
    String data =null;
    boolean retValue;
    public void MyProd () throws  Exception {
        while (falg){
            data=  atomicInteger.incrementAndGet()+"";
            retValue= blockingQueue.offer( data,2L, TimeUnit.SECONDS );
            if (retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep( 1 );
        }
        System.out.println(Thread.currentThread().getName()+"\t 大老板叫停,标识falg为false,生产结束");
    }
    public void MyConsumer () throws  Exception{
        String result=null;
        while (falg){
            result=  blockingQueue.poll( 2l,TimeUnit.SECONDS );
            if (result==null|| result.equalsIgnoreCase( "" )){
                falg=false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒中没有取到,消费推出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }


    }
    public void stop()throws  Exception{
        this.falg=false;
    }

}
//生产者消费者阻塞队列
public class TestProdCunsumer_BlockQueue {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource( new LinkedBlockingQueue<>( 3 ) );
        new Thread( ()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.MyProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod" ).start();
        new Thread( ()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.MyConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer" ).start();
        TimeUnit.SECONDS.sleep( 5 );
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒时间到大老板叫停,活动结束");

        myResource.stop();


    }
}
