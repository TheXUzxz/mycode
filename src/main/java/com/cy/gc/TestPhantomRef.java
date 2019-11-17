package com.cy.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

//虚引用不会决定对象的生命周期,任何时候都可能被当成垃圾回收get()方法每次都返回null
public class TestPhantomRef {
    public static void main(String[] args)throws  Exception {
        Object o1  = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference =
                new PhantomReference<>( o1,referenceQueue );
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("============================");
        o1=null;
        System.gc();
        Thread.sleep( 500 );

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }
}
