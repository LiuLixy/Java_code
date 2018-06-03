package 聊天室;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("等待客户端连接...");
			// 返回客户端 Socket 实例
			Socket client = serverSocket.accept();
			// 获取输出流
			PrintStream ps = new PrintStream(client.getOutputStream());
			ps.print("Hello I'm Server !!"+serverSocket.getLocalPort()+"\n");
			// 获取输入流
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(client.getInputStream());
			scanner.useDelimiter("\n");
			if (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			serverSocket.close();
		} catch (Exception e) {
			
		}
	}
}
