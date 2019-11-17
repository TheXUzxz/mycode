package com.cy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Alcortion{
    private int  number=0;
    private Lock lock = new ReentrantLock(  );
    private Condition condition =lock.newCondition();
        public void incrrment()throws Exception{
            lock.lock();
               try {
                    //判断
                    while (number!=0){

                        condition.await();//等待,类似Object.wait

                    }
                    number++;
                   System.out.println(Thread.currentThread().getName()+"\t"+number);
                   //通知
                  // this.notifyAll();
                   condition.signalAll();

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
        }
    public void decrrment()throws Exception{
        lock.lock();
        try {
            //判断
            while (number==0){

                condition.await();//等待,类似Object.wait

            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知
            // this.notifyAll();
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
   /* public synchronized void incrrment()throws Exception{
        //判断
        while (number!=0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
    public synchronized void decrrment()throws Exception{
        //判断
        while (number==0){
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }*/

}
/**
 *
 *  判断/干活/分析
 *      防止多线程的虚假唤醒
 *      判断必须要用while
 *
 *
 * */
public class ProdConsumer {
    public static void main(String[] args) {
        Alcortion a = new Alcortion();
        new Thread( ()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    a.incrrment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A" ).start();
        new Thread( ()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    a.decrrment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B" ).start();
        new Thread( ()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    a.incrrment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C" ).start();
        new Thread( ()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    a.decrrment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"D" ).start();

    }
}
