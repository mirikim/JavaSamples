package Day21_160126;

import java.net.*;

public class NetWorkEx2 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.javachobo.com:80/sample/hello.html?referer=javachobo#index1");

		System.out.println("url.getAuthority(): " + url.getAuthority());// 호스트명과
																		// 포트를문자열로
	//	System.out.println("url.getContent() :" + url.getContent());// URL의
																	// Content객체
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort());
		System.out.println("url.getPort() : " + url.getPort());//포트번호가져오기
		System.out.println("url.getFile() :" + url.getFile());//
		System.out.println("url.getHost()" + url.getHost());
		System.out.println("url.getPath() : " + url.getPath());
		System.out.println("url.getProtocol(): " + url.getProtocol());
		System.out.println("url.getQuery() :" + url.getQuery());
		System.out.println("url.getRef() :" + url.getRef());
		System.out.println("url.getUserInfo() :" + url.getUserInfo());
		System.out.println("url.toExternalForm() :" + url.toExternalForm());// URL을문자열로반환
		System.out.println("url.toURI() :" + url.toURI());

	}
}
