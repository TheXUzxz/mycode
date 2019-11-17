package com.cy.gc;

import java.util.HashMap;
import java.util.WeakHashMap;

//弱引用HashMap`
public class TestWeakHashMap {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("=======================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String > map  = new WeakHashMap<>(  );
        Integer key = new Integer( 1 );
        String value = "hashMap";
        map.put( key,value );
        System.out.println(map);
        key =null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t "+map.size());
    }

    private static void myHashMap() {
       HashMap<Integer,String > map  = new HashMap<>(  );
       Integer key = new Integer( 1 );
       String value = "hashMap";
       map.put( key,value );
        System.out.println(map);
        key =null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t "+map.size());

    }
}
