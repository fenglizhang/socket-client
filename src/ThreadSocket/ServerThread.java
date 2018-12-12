package ThreadSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求。
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is=socket.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("客户端说： "+info);
			}
			//关闭输入流
			socket.shutdownInput();
			//获取输出流，相应客户端的请求
			os=socket.getOutputStream();
			pw=new PrintWriter(os);
			pw.write("欢迎你！客户端。。。");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw !=null){
				pw.close();
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br !=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(isr!=null){
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is !=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket !=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
