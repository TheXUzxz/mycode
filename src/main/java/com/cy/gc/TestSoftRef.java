package com.cy.gc;

import java.lang.ref.SoftReference;

//软引用,内存够不会收,内存不够回收为了尽量不发生OOM通常用于缓存中
public class TestSoftRef {

    public static void soft_Memory_Enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>( o1 );
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    public static void soft_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>( o1 );
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;


        try {
            byte[ ] bytes = new byte[30*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }


    }
    public static void main(String[] args) {
       // soft_Memory_Enough();
        soft_Memory_NotEnough();
    }
}
