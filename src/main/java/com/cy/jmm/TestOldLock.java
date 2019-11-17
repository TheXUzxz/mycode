package com.cy.jmm;

import java.util.concurrent.TimeUnit;

/**
 *      产生死锁的主要原因
 *              系统资源不足
 *              进程运行推进的顺序不合适
 *              资源分配不当
 *
 *
 * */
    class  HoodLockThread implements  Runnable{
        private String lockA;
        private String lockB;

    public HoodLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+
                    "\t 自己持有:"+lockA+"\t 尝试获取:"+lockB);
             try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}

             synchronized (lockB){
                 System.out.println(Thread.currentThread().getName()+
                         "\t 自己持有:"+lockB+"\t 尝试获取:"+lockA);
             }
        }

    }
}

public class TestOldLock {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread( new HoodLockThread( lockA,lockB ),"ThreadAAA"  ).start();
        new Thread( new HoodLockThread( lockB,lockA ),"ThreadBBB"  ).start();

        /** linux ps -ef|grep xxx
         *  jps:查看Java运行程序的进程命令
         *
         *      jps -l //定位进程号
         *
         *
         *      jstack找到死锁查看
         *      "ThreadBBB":
                at com.cy.jmm.HoodLockThread.run(TestOldLock.java:30)
         -  waiting to lock <0x00000000d5f48cd8> (a java.lang.String)
            - locked <0x00000000d5f48d10> (a java.lang.String)
            at java.lang.Thread.run(Thread.java:748)
         "ThreadAAA":
         at com.cy.jmm.HoodLockThread.run(TestOldLock.java:30)
         - waiting to lock <0x00000000d5f48d10> (a java.lang.String)
         - locked <0x00000000d5f48cd8> (a java.lang.String)
         at java.lang.Thread.run(Thread.java:748)

         Found 1 deadlock.

         *
         *
         * */
    }

}
