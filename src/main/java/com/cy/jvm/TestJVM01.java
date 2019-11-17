package com.cy.jvm;

public class TestJVM01 {
    public static void main(String[] args) {
        //null
        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());

        // sun.misc.Launcher$ExtClassLoader@6d6f6e28
       // sun.misc.Launcher$AppClassLoader@18b4aac2
        TestJVM01 testJVM01 = new TestJVM01();
        System.out.println(testJVM01.getClass().getClassLoader().getParent().getParent());
        System.out.println(testJVM01.getClass().getClassLoader().getParent());
        System.out.println(testJVM01.getClass().getClassLoader());


    }
}
