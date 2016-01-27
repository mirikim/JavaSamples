package Day22_160127;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap clients;

	public TcpIpMultichatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);//해쉬맵을 동기화시킴
	}

	public void start() {
		ServerSocket serverSocket = null;//
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7777);//서버소켓객체생성
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();//request가 오면 소켓을 생성하고
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);//쓰레드를 생성한다 이쓰레드를 가지고 클라이언트와 대응하라
				thread.start();//쓰레드 시작
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// start()

	void sendToAll(String msg) {//모든클라이언트에게 메시지를 전송
		Iterator it = clients.keySet().iterator();//해쉬맵에들어가있는 클라이언트하나씩 

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());//iterator가르키는 다음요소를 get
				out.writeUTF(msg);//위에서 생성된 out(다음요소를)을 UTF로 써준다.
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
				name = in.readUTF();//클라이언트가 입력한 닉네임
				sendToAll("#" + name + "님이 들어오셨습니다.");

				clients.put(name, out);//name을 해쉬맵의 key로 하고 out(사용자가 입력한 메시지)를 해쉬맵에 넣는다.
				System.out.println("현재 서버 접속자 수는 : " + clients.size() + "입니다.");
				while (in != null) {
					sendToAll(in.readUTF());
				}

			} catch (IOException e) {
//ignore
			} finally {
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);//해당클라이언트를 해쉬맵에서 삭제.
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
			} // try
		}// run
	}// ReceiverThread
}// class