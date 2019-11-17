package com.cy.company.servlet;

import java.io.IOException;
import java.net.ServerSocket;

public class TestServerSocket {
	public static void main(String[] args) throws IOException {
		ServerSocket  serverSocket = new ServerSocket(8888);
		System.out.println("服务器启动成功");
		serverSocket.accept();	
		System.out.println("客户端已连接");
	}
}
