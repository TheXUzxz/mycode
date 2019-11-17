package com.cy.gc;

import java.util.Random;
//-Xms10m -Xmx10m  -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseParNewGC
public class  TestHeapSpaceError {
    public static void main(String[] args) {
        String str ="sdwdw";
        while (true){
            str+=str +new Random(  ).nextInt( 111111111 )+
                    new Random(  ).nextInt( 2222 );
            str.intern();
        }
//        byte[] bytes = new byte[30*1024*1024];
    }
}
