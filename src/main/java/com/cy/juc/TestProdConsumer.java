package com.cy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class A{
    private int num=0;
    Lock lock = new ReentrantLock(  );
    Condition condition=lock.newCondition();
    public  void incrrent() throws Exception{
        lock.lock();
           try {
               while (num!=0){
                   //this.wait();
                   condition.await();
               }
               num++;
               System.out.println(Thread.currentThread().getName()+"\t"+num);
             //  this.notifyAll();
               condition.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }



    }
    public  void decrrent() throws Exception{
        lock.lock();
        try {
            while (num==0){
                //this.wait();
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //  this.notifyAll();
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }



    }




}
public class TestProdConsumer {
    public static void main(String[] args) {
        A a = new A();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    a.incrrent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    a.decrrent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    a.incrrent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    a.decrrent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D" ).start();
    }
}
