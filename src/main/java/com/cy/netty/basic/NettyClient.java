package com.cy.netty.basic;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient  {
    public static void main(String[] args)throws  Exception {
        //创建一个线程组
        NioEventLoopGroup group = new NioEventLoopGroup();
        //创建客户端的启动助手完成相关配置
        Bootstrap bootstrap = new Bootstrap();
        //设置线程组
        bootstrap.group( group )
                //设置客户端通道实现类
                .channel( NioSocketChannel.class )
                .handler( new ChannelInitializer<SocketChannel>() {//创建一个通道初始化对象

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //往pipeline里添加自定义的Handler对象
                        pipeline.addLast( new NettyClientHandler() );
                    }
                } );
        System.out.println("client is ready");
        //启动客户端连接服务端
        ChannelFuture cf = bootstrap.connect( "127.0.0.1", 9999 ).sync();
        //关闭连接
        cf.channel().close().sync();

    }

}
