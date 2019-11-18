package com.cy.netty.basic;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.Charset;

//服务器端的业务处理类
public class NettyServer {
    public static void main(String[] args)throws  Exception{
        //1创建一个线程组,接收客户端连接
        EventLoopGroup boosGroup= new NioEventLoopGroup(  );
        //创建一个线程组,处理网络操作
        EventLoopGroup  workGroup=   new NioEventLoopGroup(  );
        //3,创建服务器端启动助手
        ServerBootstrap b = new ServerBootstrap();
        //4设置两个线程组
        b.group( boosGroup,workGroup )
                //5使用NioServerSocketChannel作为服务器端通道的实现
                .channel( NioServerSocketChannel.class )
                //设置线程队列中等待连接的个数
                .option( ChannelOption.SO_BACKLOG,128 )
                //保持活动连接状态
                .childOption( ChannelOption.SO_KEEPALIVE,true )
                //8创建一个通道初始化对象
                .childHandler( new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                       //9往pipeline链中一添加自定义的Handler类
                        socketChannel.pipeline().addLast( new NttyServerHandler() );
                    }
                } );
            System.out.println("...........server is ready.........");
            //10绑定端口号,指定异步
        ChannelFuture cf = b.bind( 9999 ).sync();
        System.out.println("server is starting");
        //11关闭通道,关闭线程组

        cf.channel().closeFuture().sync();
        boosGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
