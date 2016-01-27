package Day22_160127;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class TcpIpServer3 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				// ��������
				System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
				// ��û ���ð��� 5�ʷ� �����Ѵ�.
				// 5�ʵ��� ���ӿ�û�� ������ SocektTimeoutException�� �߻��Ѵ�.
				serverSocket.setSoTimeout(5 * 1000);
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");

				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// ���ݼ���(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");

				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
			} catch (SocketTimeoutException e) {
				System.out.println("������ �ð����� ���ӿ�û�� ��� ������ �����մϴ�.");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	}// main
		// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�

	static String

	getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}// class