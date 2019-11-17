package com.cy.gc;
//强引用
public class TestStroongRef {
    public static void main(String[] args) {
        Object o1 =new Object();
        Object o2 = o1;
        o1=null;
        System.gc();
        System.out.println(o2);
    }
}
