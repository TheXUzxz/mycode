package com.cy.juc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class Phone{
    public  static synchronized  void  sendEmal()throws  Exception{
        TimeUnit.SECONDS.sleep( 4 );
        System.out.println("sendEmal()..");
    }
    public  synchronized  void  call()throws  Exception{

        System.out.println("call()..");
    }
    public void sayHello()throws Exception{
        System.out.println("sayHello()...");
    }
}

    //1标准访问,先打印邮件,还是电话
    //2暂停4秒邮件方法,还是先打印sendEmal()..
//一个对象里面如果有多个synchronized方法,
// 某一个时刻内,只要有一个线程去调用其中的一个synchronized方法,
// 其他线程都只能等待,换句话说某一一个时刻内,
// 只能有唯一一个线程去访问这些synchronized方法,
// 锁的当前对象this,被锁之后其它线程都不能进入到当前对象的其它synchronized方法
    //3新增普通sayHello方法,先打印邮件还是sayHello()...,先sayHello()...
         //加上普通方法后和同步锁无关
    //4两个phone 先打印sendEmal还是call,先打印call()..
        //换成两个对象不是同一把锁
    //5两个静态同步方法 同一部手机,先打印邮件还是call,等待4秒先打印sendEmal()..
    //6两个静态同步方法,两部手机,先打印邮件还是call,先sendEmal()..

        //静态同步锁,锁的是当前类的Class对象
    //7,一个静态同步方法一个普通同步方法,同一部手机,先打印call()..
    //8,一个静态同步方法一个普通同步方法,两部手机,call()..
public class Lock8D05 {
    public static void main(String[] args) throws  Exception {
        Phone p = new Phone();
        Phone p2 = new Phone();
        new Thread( ()->{
            try {
                p.sendEmal();
               // Phone.sendEmal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A" ).start();
        Thread.sleep( 100 );
        new Thread( ()->{
            try {
                //p.call();
             p.sayHello();
               //p2.call();
                //Phone.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"b" ).start();
    }

}
