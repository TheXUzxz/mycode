package com.cy.jmm;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{  //资源类
    private int num =0;
    private Lock lock = new ReentrantLock(  );
    private Condition condition =lock.newCondition();
    public void incrment()throws  Exception {
        lock.lock();
           try {

               //判断
               while (num!=0){ //如果使用if会造成虚假唤醒
                   //等待不能生产
                   condition.await();

               }
               //干活
               num++;
               System.out.println(Thread.currentThread().getName()+"\t"+num);

               //通知唤醒
               condition.signalAll();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }


    }

    public void decrment()throws  Exception{
        lock.lock();
        try {

            //判断
            while (num==0){
                //等待不能生产
                condition.await();

            }
            //干活
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);

            //通知唤醒
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }






}
//一个初始值为0的变量,两个线程对其交替操作,一个加1一个减1,乘5轮
/***
 * 线程       操作(方法)           资源类
 * 判断      干活            通知
 * 防止虚假唤醒机制
 * ****/
public class TestProdConsumer_Tradition {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread( ()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.incrment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"AA" ).start();

        new Thread( ()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BB" ).start();
        new Thread( ()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.incrment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"CC" ).start();

        new Thread( ()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"DD" ).start();
    }
}
