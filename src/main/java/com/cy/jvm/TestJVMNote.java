package com.cy.jvm;

import java.util.Random;
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
public class TestJVMNote {
    public static void main(String[] args) {
        String str ="hahah";
        while (true){
            str+=str+new Random(  ).nextInt(8888)+new  Random(  ).nextInt(9999);

        }
    }
}
