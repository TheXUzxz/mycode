package com.cy.jvm;
//方法区 线程共享区,存在垃圾回收
//6.stack 栈管运行,堆管存储
    //队列 FIFO先进先出
    //栈 先进后出
/**
 *  6.1栈保存那些东西
 *      8种基本类型  引用类型变量
 *
 * */

public class TestJVM02 {
    public  static  void m1( ){
        m1();
    }
   // Exception in thread "main" java.lang.StackOverflowError 错误,不是异常
    public static void main(String[] args) {

        m1();

    }
}
