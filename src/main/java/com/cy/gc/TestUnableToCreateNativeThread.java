package com.cy.gc;

import java.util.concurrent.TimeUnit;

//与对应的平台有关
    //导致原因
        //应用创建线程过多
        //服务器不允许应用创建这么多线程
public class TestUnableToCreateNativeThread {
    public static void main(String[] args) {
      for (int i=1; ;i++){

          System.out.println(i);
      }
    }
}
