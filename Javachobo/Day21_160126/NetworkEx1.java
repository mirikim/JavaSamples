package Day21_160126;

import java.net.*;
import java.util.*;

public class NetworkEx1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;

		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			//도메인이름이 출력
			System.out.println("getHostAddress() :" + ip.getHostAddress());
			//ip주소가 출력
			System.out.println("toString() : " + ip.toString());
			//도메인이름과 ip주소가 동시에 출력됨

			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() :" + Arrays.toString(ipAddr));

			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			System.out.println("getAddress()+256 :" + result);
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() :" + ip.getHostName());
			System.out.println("getHostAddress() :" + ip.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			//도메인명에지정된 모든 호스트의 IP주소를 배열에 담아 반환한다.
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}// main
}
