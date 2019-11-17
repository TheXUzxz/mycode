package com.cy.mynio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 网络客户端程序
 *
 * */
public class NIOClient {
    public static void main(String[] args)throws  Exception {


        //1得到一个网络通道
        SocketChannel channel = SocketChannel.open();

        //2设置非阻塞方式
        channel.configureBlocking( false);

        //3提供服务器端的的ip地址和端口号
        InetSocketAddress inet = new InetSocketAddress( "127.0.0.1", 9999 );
        //连接服务器端
        if (!channel.connect( inet )) {
            while (!channel.finishConnect()) {//nio作为非阻塞式io的优势
                System.out.println("Client:连接服务器的同时可以做别的事情");

            }
        }

        //5得到一个缓冲区,并存入数据
        String str ="hello Server";
        ByteBuffer  writeBuffer=ByteBuffer.wrap( str.getBytes() );

        //6向服务端发送数据
        channel.write( writeBuffer );

        System.in.read();//阻塞当前程序

    }

}
