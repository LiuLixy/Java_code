package ������;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
	public static void main(String[] args) {
		try {
			// �������ӷ������Ŀͻ����׽���
			Socket socket = new Socket("127.0.0.1", 6666);
			System.out.println("�ȴ����ӷ�����...");
			// ��ȡ����������ȡ��������Ϣ
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(socket.getInputStream());
			scanner.useDelimiter("\n");
			if (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			// ��ȡ��������������������Ϣ
			PrintStream pStream = new PrintStream(socket.getOutputStream(), true);
			pStream.print("Hello I'm Client !!!" + socket.getLocalPort() + "\n");
			socket.close();
		} catch (Exception e) {
			
		}
	}
}
