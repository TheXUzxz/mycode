package com.cy.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>(  );
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock( );

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();//写锁,写是独占需要注意并发性
           try {
               System.out.println(Thread.currentThread().getName()+"\t 开始写入数据"+key);
               try { TimeUnit.MILLISECONDS.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
               map.put( key,value );
               System.out.println(Thread.currentThread().getName()+"\t 写入完成");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
               readWriteLock.writeLock().unlock();
                }

    }

    public void get(String key){
        readWriteLock.readLock().lock();//读锁,不是独占
           try {
               System.out.println(Thread.currentThread().getName()+"\t 开始读取数据");
               try { TimeUnit.MILLISECONDS.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
               Object result = map.get( key );
               System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
               readWriteLock.readLock().unlock();
                }

    }

}
public class TestReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
           final int temp = i;
            new Thread( ()->{
                myCache.put(temp+"",temp+""  );
            },String.valueOf( i )).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread( ()->{
                myCache.get(temp+"");
            },String.valueOf( i )).start();
        }

    }


}
