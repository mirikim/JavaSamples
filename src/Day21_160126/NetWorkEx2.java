package Day21_160126;

import java.net.*;

public class NetWorkEx2 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.javachobo.com:80/sample/hello.html?referer=javachobo#index1");

		System.out.println("url.getAuthority(): " + url.getAuthority());// ȣ��Ʈ���
																		// ��Ʈ�����ڿ���
	//	System.out.println("url.getContent() :" + url.getContent());// URL��
																	// Content��ü
		System.out.println("url.getDefaultPort() : " + url.getDefaultPort());
		System.out.println("url.getPort() : " + url.getPort());//��Ʈ��ȣ��������
		System.out.println("url.getFile() :" + url.getFile());//
		System.out.println("url.getHost()" + url.getHost());
		System.out.println("url.getPath() : " + url.getPath());
		System.out.println("url.getProtocol(): " + url.getProtocol());
		System.out.println("url.getQuery() :" + url.getQuery());
		System.out.println("url.getRef() :" + url.getRef());
		System.out.println("url.getUserInfo() :" + url.getUserInfo());
		System.out.println("url.toExternalForm() :" + url.toExternalForm());// URL�����ڿ��ι�ȯ
		System.out.println("url.toURI() :" + url.toURI());

	}
}
