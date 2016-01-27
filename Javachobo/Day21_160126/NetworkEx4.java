package Day21_160126;

import java.net.*;
import java.io.*;

public class NetworkEx4 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.naver.com";
		String line = "";
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			// openStream(): URL�� InputStream���
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
