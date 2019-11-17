package com.cy.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Ticket   //资源类=实例变量+实例方法

{
    private int num =30;
    //synchronized
    Lock lock =new  ReentrantLock();//可重入锁
    public  void sale(){

        lock.lock();
        try {
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(num--)+"\t还剩:"+num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
//在高内聚低耦合的前提下, 线程  操作  资源类
//先创建一个资源类
public class SaleTicketDemo01 {
    //主线程  一切程序的入口
    public static void main(String[] args){
        Ticket ticket = new Ticket();
        new Thread( () -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "A" ).start();
        new Thread( () -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "B" ).start();
        new Thread( () -> { for (int i = 1; i < 40; i++) ticket.sale(); }, "C" ).start();
        }




}
