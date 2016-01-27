package Day22_160127;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);// ��밡�� port : 0-65536,
													// 1023�̻��� ��Ʈ��ȣ ��� �ʿ� �׾չ�ȣ��
													// ������ �Ҵ�� ��Ʈ����
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true)

		{
			try {
				System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
				// ���������� Ŭ���̾�Ʈ�� �����û�� �ö����� ������ ���߰� ��ӱ�ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.

				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				// ������ �ش� IP�ּҸ� ��´�.
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// ���ݼ���(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");

				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();//����� ������ �������� �ݾ�����Ѵ�.
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while

	}// main
		// ����ð��� ���ڿ��� ��ȯ�ϴ� �Լ�

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}// class