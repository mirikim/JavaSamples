package HomeWorkhb;

import java.net.*;
import java.io.*;
import java.util.*;

///�������� GUI�������� ä���������α׷�¥�� _ ���̾�α׿�������1/31����
public class TcpIpMultichatClient {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java TcpIpMultichatClient ��ȭ��");
			System.exit(0);
		}
		try {
			String serverIp = "127.0.0.1";
			// ��Ĺ�� �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("������ ����Ǿ����ϴ�.");

			Thread sender = new Thread(new ClientSender(socket, args[0]));
			// ���������κ����� �����带 �����ϴµ� parameter�� �����ڸ޼��带 ȣ��
			Thread receiver = new Thread(new ClientReceiver(socket));
			// �����ʿ��� ������, ������ sendToAll��������

			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	}// main

	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;

		public ClientSender(Socket socket, String name) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
			}
		}

		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if (out != null) {
					out.writeUTF(name);
				}
				while (out != null) {
					out.writeUTF("[" + name + "]" + scanner.nextLine());
					// �޽����� �Է¹޾Ƽ� DataOutputStream�� write =>�޽���������
				}
			} catch (IOException e) {
			}
		}// run()
	}

	// ������ sendToAll�޼��忡 ���� ������ �޽����� �޴´�.
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		public ClientReceiver(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {

			}
		}

		public void run() {
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
				}
			}
		}// run
	}
}// class
