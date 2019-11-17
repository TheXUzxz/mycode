package com.cy.jmm;


//

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**1.原始构成
 * synchronized是关键字是JVM层面   monitorenter
 * monitorexit//出现两次 一个正常推出一个异常退出
 * lock 是具体类  是API层面的锁
 *
 *
 *  2使用方法
 *      synchronized 不需要用户去手动释放锁,
 *      当synchronized代码执行完成后系统会自动让线程释放对锁的占用
 *      ReentrantLock 则需要用户去手动释放锁,如果没有手动释放,就有可能出现死锁
 *      需要lock();和unLock();
 *
 *  3.等待是否可中断
 *          synchronized不可中断,除非排除异常,或者正常执行完成
 *          ReentrantLock 可以中断 1.设置超时方法trylock(long timeout,TimeUnit unit)
 *                                  2.lockInterruptibly()放代码块中,调用interrupt()方法可中断
 *
 *
 *  4.公平锁非公平锁
 *      synchronized非公平锁
 *      ReentrantLock默认是非公平,也可以是公平
 *  5.绑定多个条件Condition
 *        synchronized:没有
 *          ReentrantLock:用来实现分组唤醒需要唤醒的线程们 ,可以精确唤醒不像synchronized
 *          要么唤醒一个线程,要么唤醒多个线程
 *
 *
 *
 *
 *
 * **/
//多线程按照顺序调用
    class ShareResource{
        private int num =1;//A:1 B:2 C:3
        private Lock lock = new ReentrantLock(  );
        Condition c1 = lock.newCondition();
         Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();


        public void printFive(){
            lock.lock();
               try {
                   //判断
                   while (num!=1){
                       c1.await();
                   }
                   //干活
                   for (int i = 0; i <5 ; i++) {
                       System.out.println(Thread.currentThread().getName()+"\t"+i);
                   }


                   //通知
                   num=2;
                   c2.signalAll();

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
        }

    public void print10(){
        lock.lock();
        try {
            //判断
            while (num!=2){
                c2.await();
            }
            //干活
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }


            //通知
            num=3;
            c3.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            //判断
            while (num!=3){
                c3.await();
            }
            //干活
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }


            //通知
            num=1;
            c1.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }




}
public class TestSyncAndLock {
    public static void main(String[] args) throws InterruptedException {
        ShareResource shareResource = new ShareResource() ;
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.printFive();
            }

        },"A" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print10();
            }

        },"B" ).start();
        new Thread( ()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print15();
            }

        },"C" ).start();

    }
}