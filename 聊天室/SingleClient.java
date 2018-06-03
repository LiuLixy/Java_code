package 聊天室;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
	public static void main(String[] args) {
		try {
			// 创建连接服务器的客户端套接字
			Socket socket = new Socket("127.0.0.1", 6666);
			System.out.println("等待连接服务器...");
			// 获取输入流，读取服务器信息
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(socket.getInputStream());
			scanner.useDelimiter("\n");
			if (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			// 获取输出流，向服务器发送信息
			PrintStream pStream = new PrintStream(socket.getOutputStream(), true);
			pStream.print("Hello I'm Client !!!" + socket.getLocalPort() + "\n");
			socket.close();
		} catch (Exception e) {
			
		}
	}
}
