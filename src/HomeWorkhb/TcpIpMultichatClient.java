package HomeWorkhb;

import java.net.*;
import java.io.*;
import java.util.*;

///스윙으로 GUI형식으로 채팅으로프로그램짜기 _ 다이얼로그예제참고1/31까지
public class TcpIpMultichatClient {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java TcpIpMultichatClient 대화명");
			System.exit(0);
		}
		try {
			String serverIp = "127.0.0.1";
			// 소캣을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");

			Thread sender = new Thread(new ClientSender(socket, args[0]));
			// 서버쪽으로보낼대 쓰레드를 생성하는데 parameter로 생성자메서드를 호출
			Thread receiver = new Thread(new ClientReceiver(socket));
			// 서버쪽에서 받을때, 서버의 sendToAll을받을때

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
					// 메시지를 입력받아서 DataOutputStream에 write =>메시지날린다
				}
			} catch (IOException e) {
			}
		}// run()
	}

	// 서버의 sendToAll메서드에 의해 보내는 메시지를 받는다.
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
