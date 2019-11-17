package com.cy.jmm;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArrayList {
    //java.util.concurrentModificationException
     //concurrentModificationException
    //concurrentModification
    //concurrentModification
    //concurrentModification
    //concurrentModification
    public static void main(String[] args) {
        List<String> list = new  CopyOnWriteArrayList();
        //Collections.synchronizedMap(  )
        //Collections.synchronizedSet(  )
        //

//        list.stream().forEach( System.out::println );
        for (int i = 0; i < 30; i++) {
            new Thread( ()->{
                list.add( UUID.randomUUID().toString().substring( 0,3 ) );
                System.out.println(list);
            },String.valueOf( i ) ).start();
        }

    }
}
//故障现象,concurrentModificationException


//导致原因
/**
 * 三种
 *  1.1 new Vector();
 *  1.2 Collections.synchronizedMap
 *  1.3
 */


//解决方案