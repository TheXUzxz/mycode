package com.cy.jmm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

//Set线程不安全
public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet(  );
        for (int i = 0; i < 30; i++) {
            new Thread( ()->{
                set.add( UUID.randomUUID().toString().substring( 0,3 ) );
                System.out.println(set);
            },String.valueOf( i ) ).start();
        }

    }

}
