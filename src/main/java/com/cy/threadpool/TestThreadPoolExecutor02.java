package com.cy.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor02 {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor  threadPool = new ThreadPoolExecutor(
                2,
                i+1,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(  ),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
