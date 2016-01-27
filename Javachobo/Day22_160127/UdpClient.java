package Day22_160127;

import java.net.*;
import java.io.*;

public class UdpClient {
	public void start() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

		// �����Ͱ� ����� �������� byte�迭�� �����Ѵ�.
		byte[] msg = new byte[100];

		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		// �����͸� �۽��ϱ� ���� �����ڷ� serverAddress�� ��Ʈ7778�� �迭 msg�� ���� 1��ŭ�����Ѵ�.
		
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		//�����͸� �����ϱ� ���� �����ڷ� ����Ʈ�迭 msg�� msg.length��ŭ �����Ѵ�.

		datagramSocket.send(outPacket);// DatagramPacket�� �����Ѵ�.
		datagramSocket.receive(inPacket);// DatagramPacket�� �����Ѵ�.

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
