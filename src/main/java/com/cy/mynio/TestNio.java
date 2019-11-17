package com.cy.mynio;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//通过nio实现文件io
public class TestNio {

    @Test //往本地文件写数据
    public  void test1()throws  Exception{
        //1.创建输出流
        FileOutputStream fos = new FileOutputStream( "basc.txt" );
        //2从流中获取一个通道
        FileChannel fc = fos.getChannel();
        //3.提供一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        //4往缓冲区写数据
        String str = "hello.nio";
        buffer.put( str.getBytes() );
        //5反转缓冲区
        buffer.flip();
        //6把缓冲区写到通道中
        fc.write( buffer );
        //7释放资源
        fos.close();
    }
    @Test  //从本地文件中读数据

    public void test2()throws Exception {
        File file = new File( "basc.txt" );

     //1.创建输入流
        FileInputStream  fis =new FileInputStream( file);
        //2得到一个通道
        FileChannel fc = fis.getChannel();
        //准备一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate( (int) file.length() );
        //从通道读取数据,存入缓冲区
        fc.read(buffer  );
        //从缓冲区读数据
        System.out.println(new  String(buffer.array()));
        //关闭
        fis.close();
    }


    @Test  //使用NIO实现文件复制

    public void test3()throws Exception {
        //创建两个流
        FileInputStream fis = new FileInputStream( "basc.txt" );
        FileOutputStream fos = new FileOutputStream( "f:\\test\\basc.txt" );


        //得到两个通道
        FileChannel source = fis.getChannel();
        FileChannel destFc = fos.getChannel();
        //复制
        destFc.transferFrom( source,0,source.size() );
       // source.transferTo(source.size(),0L,destFc  );

        //关闭
        fis.close();
        fos.close();

    }
}
