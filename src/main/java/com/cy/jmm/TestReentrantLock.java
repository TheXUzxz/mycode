package com.cy.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public  synchronized  void senSMS(){
        System.out.println(Thread.currentThread().getName()+"\t invoke senSMS()");
        sendEmail();
    }
    public synchronized  void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t invoke sendMail()");

    }
    Lock lock = new ReentrantLock(  );
    @Override
    public void run() {
        get();

    }

    private void get() {
        lock.lock();
        lock.lock();
           try {
               System.out.println(Thread.currentThread().getName()+"\t invoke get()");
               set();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    lock.unlock();
                }
    }

    private void set() {
        lock.lock();
           try {
               System.out.println(Thread.currentThread().getName()+"\t invoke set()");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
    }
}
//同一个线程外层函数获得锁之后,内层递归函数仍然能获取该锁的代码.
//在一个线程外层方法获取锁的时候,在进入内层方法会自动获取锁
//t1	 invoke senSMS()
//t1	 invoke sendMail()
// t2	 invoke senSMS()
//  t2	 invoke sendMail()
public class TestReentrantLock {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread( ()->{
            phone.senSMS();
        },"t1" ).start();
        new Thread( ()->{
            phone.senSMS();
        },"t2" ).start();
     try{   TimeUnit.SECONDS.sleep( 1 );}catch (Exception e){}

        Thread t3 = new Thread( phone,"t3" );
        Thread t4 = new Thread( phone ,"t4");
        t3.start();
        t4.start();

    }
}
