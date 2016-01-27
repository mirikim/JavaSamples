package Day22_160127;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);// 사용가능 port : 0-65536,
													// 1023이상의 포트번호 사용 필요 그앞번호는
													// 기존에 할당된 포트들임
			System.out.println(getTime() + "서버가 준비되었습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true)

		{
			try {
				System.out.println(getTime() + "연결요청을 기다립니다.");
				// 서버소켓은 클라이언트의 연결요청이 올때까지 실행을 멈추고 계속기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.

				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
				// 소켓의 해당 IP주소를 얻는다.
				
				// 소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// 원격소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server");
				System.out.println(getTime() + "데이터를 전송했습니다.");

				// 스트림과 소켓을 닫아준다.
				dos.close();//사용한 순서의 역순서로 닫아줘야한다.
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while

	}// main
		// 현재시간을 문자열로 반환하는 함수

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}// class