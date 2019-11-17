package com.cy.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class  MyData{
    volatile int number =0;
    public void addTo(){
        this.number=60;
    }
    public void  addpLusPlus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger(  );
    public  void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
/**
 * 1. 添加了volatile,可以解决可见性问题
 *  2.验证volatile不保证原子性
 *      2.1原子性是什么意思
 *      不可分割,完整性,也即某个线程正在做某个具体业务时,中间不可以被加塞或者被分割,需要集体完整
 *      要么同时成功,要么同时失败
 *
 *
 *
 * */
public class TestVolatitle {
    public static void main(String[] args) {
       // seeOk();
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread( ()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addpLusPlus();
                    myData.addAtomic();
                }

            },String.valueOf( i )).start();
        }
            //需要等待20个线程计算完成时在用main线程获取最终结果
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int final:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t int final:"+myData.atomicInteger);
    }
//可以保证可见性及时通知其它线程,主物理内存被修改
    private static void seeOk() {
        MyData myData = new MyData();
        new Thread( ()->{
            System.out.println(Thread.currentThread().getName()+"\t com in");
            try {
                //暂停一会线程
                TimeUnit.SECONDS.sleep( 3 );
                myData.addTo();
                System.out.println(Thread.currentThread().getName()+"\t 改变了"+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA" ).start();
        //第二个线程是我们的main线程
        while (myData.number==0){
            //main,线程一直在这里等待循环,直到number的值不等于0
        }

        System.out.println(Thread.currentThread().getName()+"\t 任务完成"+myData.number);
    }
}
