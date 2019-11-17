package com.cy.mynio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

//服务器端
public class NIOServer {
    public static void main(String[] args)throws  Exception {
        //1.获取ServerSocketChannel对象
        ServerSocketChannel serverSC = ServerSocketChannel.open();
        //2获取Selector选择器对象
        Selector selector = Selector.open();
        //3绑定端口号
        serverSC.bind( new InetSocketAddress( 9999 ) );
        //4设置非阻塞
        serverSC.configureBlocking( false );

        //5把获取ServerSocketChannel对象注册给Selector
        serverSC.register( selector, SelectionKey.OP_ACCEPT );
        //6干活
        while (true) {
            //6.1监控客户端
            if ( selector.select(2000)==0){
                System.out.println("hello Server nio");
                continue;
            }
            //6.2得到SelectionKey,判断客户端事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()){//客户端连接事件
                    System.out.println("OP_ACCEPT");
                    SocketChannel socketChannel = serverSC.accept();
                     socketChannel.configureBlocking( false );
                     socketChannel.register( selector,SelectionKey.OP_READ, ByteBuffer.allocate( 1024 ) );
                }

                if (key.isReadable()){//客户端读取事件

                    SocketChannel channel = (SocketChannel) key.channel();
                     ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    channel.read( byteBuffer );
                    System.out.println("客户端发来数据");
                    byte[] array = byteBuffer.array();
                    System.out.println(new String( array ));
                }
                //6.3手动从集合中移除当前key防止重复处理
                keyIterator.remove();

            }

        }


    }
}
