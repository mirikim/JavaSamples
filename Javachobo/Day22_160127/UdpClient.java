package Day22_160127;

import java.net.*;
import java.io.*;

public class UdpClient {
	public void start() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

		// 데이터가 저장될 공간으로 byte배열을 생성한다.
		byte[] msg = new byte[100];

		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		// 데이터를 송신하기 위한 생성자로 serverAddress와 포트7778로 배열 msg에 길이 1만큼저장한다.
		
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		//데이터를 수신하기 위한 생성자로 바이트배열 msg의 msg.length만큼 저장한다.

		datagramSocket.send(outPacket);// DatagramPacket을 전송한다.
		datagramSocket.receive(inPacket);// DatagramPacket을 수신한다.

		System.out.println("current server time : " + new String(inPacket.getData()));

		datagramSocket.close();
	}// start()

	public static void main(String[] args) {
		try {
			new UdpClient().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main
}
