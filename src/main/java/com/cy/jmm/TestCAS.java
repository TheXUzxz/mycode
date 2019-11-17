package com.cy.jmm;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * CAS ====>compareAndSet
 *          比较并交换
 *
 * */
public class TestCAS {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger( 5 );
        //expect  期望值
        //update   修改值
//        System.out.println( atomicInteger.compareAndSet( 5, 2019 ) );
//        System.out.println(atomicInteger.get());
//        System.out.println( atomicInteger.compareAndSet( 5, 1024 ) );
//        System.out.println(atomicInteger.get());
        System.out.println( atomicInteger.getAndIncrement() );
    }
}
