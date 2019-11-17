package com.cy.juc;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1故障现象
 *java.util.ConcurrentModificationException
 *
 *
 * 2导致原因
 *      多线程并发修改同一个资源
 *
 * 3解决方案
 *      1.换成Vector
 *      2.Collections.synchronizedList
 *      3.CopyOnWriteArrayList<>(  ) 写时复制
 * 4.优化建议
 *      使用juc下的类
 *
 *
 * */
public class NotSafeTest03 {

    public static void main(String[] args) {
        //listNotSafe();
       // setNotSafe();
        mapNotSafe();
    }

    public  static  void listNotSafe(){
        List<String> list  =  new CopyOnWriteArrayList<>(  );
        for (int i = 1; i < 30; i++) {
            new Thread( ()->{
                list.add( UUID.randomUUID().toString().substring( 0,8 ) );
                System.out.println(list);
            },String.valueOf( i ) ).start();
        }
    }
    public  static  void setNotSafe(){

        Set<String> set = new CopyOnWriteArraySet<>(  );
        for (int i = 1; i < 30; i++) {
            new Thread( ()->{
                set.add( UUID.randomUUID().toString().substring( 0,8 ) );
                System.out.println(set);
            },String.valueOf( i ) ).start();
        }

    }
    public  static  void mapNotSafe(){
        Map<String,String> map = new ConcurrentHashMap<>(  );
        for (int i = 0; i < 30; i++) {
            new Thread( ()->{
                map.put( Thread.currentThread().getName(),UUID.randomUUID().toString() );
                System.out.println(map);
            },String.valueOf( i ) ).start();
        }
    }
}
