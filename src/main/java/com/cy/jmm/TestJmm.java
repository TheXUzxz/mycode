package com.cy.jmm;

import javax.sound.midi.Soundbank;

class T1{
      volatile int num=10;
    public  void addNum() {
        this.num=1025;
    }
}
public class TestJmm {
    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread( ()->{
            try {
                Thread.sleep( 3000 );
                t1.addNum();
                System.out.println(Thread.currentThread().getName()+"\t"+t1.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A" ).start();

      while (t1.num==10){

    }
        System.out.println("main");
    }

}
