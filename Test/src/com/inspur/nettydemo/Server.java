package com.inspur.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Server {
	
	public static void main(String[] args) throws Exception {
		// 1.第一个线程组是用于接收Client端连接的。
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		// 2.第二个线程组是用于实际的业务处理操作的。
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		// 3.创建一个辅助类bootstrap，就是对我们的server进行一系列的配置。
		ServerBootstrap b = new ServerBootstrap();
		// 把两个工作线程组加入进来
		b.group(bossGroup, workerGroup)
		// 指定使用NioServerSockerChannel这种类型的通道。
		.channel(NioServerSocketChannel.class)
		// 一定要使用childHandler去绑定具体的事件处理器。
		.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				// 设置特殊分隔符
				ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
				sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
				// 设置字符串形式的解码
				sc.pipeline().addLast(new StringDecoder());
				sc.pipeline().addLast(new ServerHandler());	
			}
		})
		// 设置tcp缓冲区
		.option(ChannelOption.SO_BACKLOG, 128)
		// 保持连接
		.childOption(ChannelOption.SO_KEEPALIVE, true);
		
		// 绑定指定的端口进行监听
		ChannelFuture f = b.bind(8765).sync();
		
		f.channel().closeFuture().sync();
		
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
		
	}

}
