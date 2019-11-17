package com.cy.gc;


import java.lang.ref.WeakReference;

//只要垃圾回收机制一运行,不管JVM的内存空间是否足够,都会回收该对象占用的内存
public class TestWeakRef {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>( o1 );
        System.out.println(o1);
        System.out.println(weakReference.get());


        o1 =null;
        System.gc();
        System.out.println("=======================");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
