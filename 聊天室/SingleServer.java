package ������;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("�ȴ��ͻ�������...");
			// ���ؿͻ��� Socket ʵ��
			Socket client = serverSocket.accept();
			// ��ȡ�����
			PrintStream ps = new PrintStream(client.getOutputStream());
			ps.print("Hello I'm Server !!"+serverSocket.getLocalPort()+"\n");
			// ��ȡ������
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
