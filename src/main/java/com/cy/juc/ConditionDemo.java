package com.cy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    //标志位
    private int number =1; //A:1 B:2 C:3
    private Lock lock = new ReentrantLock(  );
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printFive(){
        lock.lock();
           try {
               //判断
               while (number!=1){
                   c1.await();

               }
               for (int i = 0; i <5 ; i++) {
                   System.out.println(Thread.currentThread().getName()+"\t"+i);
               }
                    //通知
                number =2;
                c2.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
    }
    public void printFive10(){
        lock.lock();
        try {
            //判断
            while (number!=2){
                c2.await();

            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number =3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printFive15(){
        lock.lock();
        try {
            //判断
            while (number!=3){
                c3.await();

            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number =1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args) {
        ShareData s = new ShareData();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                s.printFive();
            }
        },"A" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                s.printFive10();
            }
        },"B" ).start();
        new Thread( ()->{
            for (int i = 0; i <15 ; i++) {
                s.printFive15();
            }
        },"C" ).start();
    }
}
