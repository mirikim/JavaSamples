package Day22_160127;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap clients;

	public TcpIpMultichatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);//�ؽ����� ����ȭ��Ŵ
	}

	public void start() {
		ServerSocket serverSocket = null;//
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7777);//�������ϰ�ü����
			System.out.println("������ ���۵Ǿ����ϴ�.");

			while (true) {
				socket = serverSocket.accept();//request�� ���� ������ �����ϰ�
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] ���� �����Ͽ����ϴ�.");
				ServerReceiver thread = new ServerReceiver(socket);//�����带 �����Ѵ� �̾����带 ������ Ŭ���̾�Ʈ�� �����϶�
				thread.start();//������ ����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// start()

	void sendToAll(String msg) {//���Ŭ���̾�Ʈ���� �޽����� ����
		Iterator it = clients.keySet().iterator();//�ؽ��ʿ����ִ� Ŭ���̾�Ʈ�ϳ��� 

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());//iterator����Ű�� ������Ҹ� get
				out.writeUTF(msg);//������ ������ out(������Ҹ�)�� UTF�� ���ش�.
			} catch (IOException e) {
			}
		} // while
	}// sendToAll

	public static void main(String args[]) {
		new TcpIpMultichatServer().start();
	}

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF();//Ŭ���̾�Ʈ�� �Է��� �г���
				sendToAll("#" + name + "���� �����̽��ϴ�.");

				clients.put(name, out);//name�� �ؽ����� key�� �ϰ� out(����ڰ� �Է��� �޽���)�� �ؽ��ʿ� �ִ´�.
				System.out.println("���� ���� ������ ���� : " + clients.size() + "�Դϴ�.");
				while (in != null) {
					sendToAll(in.readUTF());
				}

			} catch (IOException e) {
//ignore
			} finally {
				sendToAll("#" + name + "���� �����̽��ϴ�.");
				clients.remove(name);//�ش�Ŭ���̾�Ʈ�� �ؽ��ʿ��� ����.
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� ������ �����Ͽ����ϴ�.");
				System.out.println("���� ���������� ���� " + clients.size() + "�Դϴ�.");
			} // try
		}// run
	}// ReceiverThread
}// class