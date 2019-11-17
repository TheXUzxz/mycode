package com.cy.jmm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>(  );
    //private Lock lock=new ReentrantLock(  );
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(  );

    public void set(String key,Object value){
        lock.writeLock().lock();
           try {
               System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
               try{    TimeUnit.MILLISECONDS.sleep( 300 );}catch (Exception e){}
               map.put( key,value );
               System.out.println(Thread.currentThread().getName()+"\t 写入完成");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.writeLock().unlock();
                }

    }
    public void get(String key){
        lock.readLock().lock();
           try {
               System.out.println(Thread.currentThread().getName()+"\t 正在读取");
               try{    TimeUnit.MILLISECONDS.sleep( 300 );}catch (Exception e){}
               Object result = map.get( key );
               System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.readLock().unlock();
                }

    }
    public void clear(){
        map.clear();
    }
}
//多个线程读一个资源没有问题,所以为了满足并发量,读取共享资源应该可以同时进行
//如果有一个线程想区写共享资源,就不应该再有其它线程可以对该资源进行读或者写
//小总结:
    //读-读能共存
    //  读-写不能共存
    //  写-写不能共存
//写操作:原子,独占,不可中断
public class TestReentrantReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i <5 ; i++) {
            final  int temint=i;
            new Thread( ()->{
                myCache.set( temint+"",temint+"" );
            },String.valueOf( i ) ).start();
        }
        for (int i = 0; i <5 ; i++) {
            final  int temint=i;
            new Thread( ()->{
                myCache.get( temint+"" );
            },String.valueOf( i ) ).start();
        }
    }
}
