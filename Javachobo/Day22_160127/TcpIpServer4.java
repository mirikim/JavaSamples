package Day22_160127;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class TcpIpServer4 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;

	public static void main(String[] args) {
		// 5���� �����带 �����ϴ� ������ �����Ѵ�.
		TcpIpServer4 server = new TcpIpServer4(5);
		server.start();
	}// main

	public TcpIpServer4(int num) {
		try {
			// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");

			threadArr = new Thread[num];

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}

	}

	public void run() {
		while (true) {
			try {
				System.out.println(getTime() + "�� �����û�� ��ٸ��ϴ�.");
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");

				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// ���ݼ���(remot socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from server");
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
	}// run

	// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date()) + name;
	}
}// class
