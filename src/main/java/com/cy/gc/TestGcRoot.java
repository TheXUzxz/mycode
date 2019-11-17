package com.cy.gc;
/**
 *      1.虚拟机栈(栈帧中的局部变量表)中引用的对象
 * 		2.方法中的类静态熟悉引用的对象
 * 		3.方法区中常量引用的对象.
 * 		4.本地方法栈中JNI(Native方法)引用的对象
 *
 *
 * */
public class TestGcRoot {

    public  static  void m1(){
        TestGcRoot testGcRoot =new TestGcRoot();
        System.gc();
        System.out.println("第一次GC完成");
    }
    public static void main(String[] args) {
     m1();
    }
}
