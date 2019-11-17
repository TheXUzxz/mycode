package com.cy.jmm;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
//手写一个自旋锁
public class TestSpinLock {
    AtomicReference<Thread> atomicReference =
            new AtomicReference<>(  );

    public void mylock(){
        Thread  thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        while (!atomicReference.compareAndSet( null, thread)){

        }

    }
    public void myUnlock(){

        Thread  thread =Thread.currentThread();
        atomicReference.compareAndSet( thread,null );
        System.out.println(Thread.currentThread().getName()+"\t invoke myUnlock");
}
    public static void main(String[] args) {
        //原子引用线程
        TestSpinLock  testSpinLock = new TestSpinLock();
        new Thread( ()->{
            testSpinLock.mylock();
        try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
            testSpinLock.myUnlock();
        },"AA" ).start();
        try{    TimeUnit.SECONDS.sleep( 1 );}catch (Exception e){}

        new Thread( ()->{
            testSpinLock.mylock();
            try{    TimeUnit.SECONDS.sleep( 1 );}catch (Exception e){}
            testSpinLock.myUnlock();
        },"BB" ).start();
    }
}
