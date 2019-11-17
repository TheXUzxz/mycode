package com.cy.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

//ABA问题的解决
public class TestAtomicTime {
    static AtomicReference<Integer> atomicReference =
            new AtomicReference<>( 100 );
    //原子时间戳
    static  AtomicStampedReference atomicStampedReference  =
            new AtomicStampedReference( 100,1 );
    public static void main(String[] args) {
        System.out.println("================以下是ABA的产生==========");
        new Thread( ()->{
            atomicReference.compareAndSet( 100,101 );
            atomicReference.compareAndSet( 101,100 );
        },"t1" ).start();

        new Thread( ()->{
            //暂停一秒钟,保证上面的t1线程执行了一次ABA
          try{  TimeUnit.SECONDS.sleep( 2 );}catch (Exception e){e.printStackTrace();}
            System.out.println( atomicReference.
                    compareAndSet( 100, 2019 )+"\t"+atomicReference.get() );

        },"B" ).start();
        try{  TimeUnit.SECONDS.sleep( 3 );}catch (Exception e){e.printStackTrace();}
        System.out.println("================以下是ABA的解决==========");

        new Thread( ()->{
            int stamp = atomicStampedReference.getStamp();//版本号
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号"+stamp);


            //暂停一秒钟
            try{  TimeUnit.SECONDS.sleep( 1 );}catch (Exception e){e.printStackTrace();}
            atomicStampedReference.compareAndSet(
                    100,101,atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1 );
            System.out.println(Thread.currentThread().getName()+"\t 第二次版本号"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(
                    101,100,atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1 );
            System.out.println(Thread.currentThread().getName()+"\t 第三次版本号"+atomicStampedReference.getStamp());

        },"t3" ).start();
        new Thread( ()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号"+stamp);


            //暂停一秒钟
            try{  TimeUnit.SECONDS.sleep( 3 );}catch (Exception e){e.printStackTrace();}
         boolean result=   atomicStampedReference.compareAndSet
                    ( 100,2019,stamp,stamp+1 );
            System.out.println(
                    Thread.currentThread().getName()+"\t" +
                            " 修改成功否"+result+"\t"+
                            "当前实际版本号"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t 当前实际最新值"+
                    atomicStampedReference.getReference());

            },"t4" ).start();

    }


}
