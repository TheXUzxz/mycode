package com.cy.gc;

import io.netty.buffer.ByteBuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

//分配在本地内存,不属于GC
public class TestDiretBufferMemory {
    public static void main(String[] args) {
        System.out.println("配置的MaxDiretBufferMemory"+
                (sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
         try{    TimeUnit.SECONDS.sleep( 5 );}catch (Exception e){}
        ByteBuffer bb= ByteBuffer.allocateDirect( 6*1024*1024 );
    }
}
