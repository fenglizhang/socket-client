package com.zhanglf.cn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port = 1122;
	private ServerSocket serverSocket;

	public Server() throws Exception {
		// ServerSocket 构造方法的 backlog 参数用来显式设置连接请求队列的长度, 它将覆盖操作系统限定的队列的最大长度.
		// 值得注意的是, 在以下几种情况中, 仍然会采用操作系统限定的队列的最大长度:
		// backlog 参数的值大于操作系统限定的队列的最大长度;backlog 参数的值小于或等于0;在ServerSocket
		// 构造方法中没有设置 backlog 参数.
		serverSocket = new ServerSocket(port, 100);
		System.out.println("服务器启动!");
	}

	public void service() {
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				System.out.println("New connection accepted "
						+ socket.getInetAddress() + ":" + socket.getPort());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		Thread.sleep(60000 * 10);
		server.service();
	}
}
