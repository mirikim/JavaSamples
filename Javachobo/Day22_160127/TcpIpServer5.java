package Day22_160127;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println("������ �غ�Ǿ����ϴ�.");

			socket = serverSocket.accept();

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			sender.start();
			receiver.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main
}// class

class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			//���ϳ� �ƿ�ǲ��Ʈ���� get�ؿ��� �޼���
			//DataOutputStream�� ���� Stream
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
		} catch (Exception e) {
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (out != null) {
			try {
				out.writeUTF(name + scanner.nextLine());
			} catch (IOException e) {
			}
		}

	}// run
}

class Receiver extends Thread {
	Socket socket;
	DataInputStream in;

	public Receiver(Socket socket) {
		// TODO Auto-generated cons
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			//���Ͽ� �մ� ��Ʈ���� �޾ƿ´�.
			
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
