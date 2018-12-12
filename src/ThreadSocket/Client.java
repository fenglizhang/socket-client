package ThreadSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		
		try {
			//1,创建客户端Socket,指定服务器地址和端口
			Socket socket=new Socket("localhost",8888);
			//2,获取字节输出流，向服务器发送信息。
			OutputStream os=socket.getOutputStream();
			//将输出流包装为打印流
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名：zhanglf;密码：3443");
			pw.flush();
			//关闭输出流
			socket.shutdownOutput();
		//3.获取输出流，并读取服务器端的响应信息
		InputStream is =socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		String info=null;
		while((info=br.readLine())!=null){
			System.out.println("服务器说："+info);
		}
		br.close();
		is.close();
		pw.close();
		os.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
