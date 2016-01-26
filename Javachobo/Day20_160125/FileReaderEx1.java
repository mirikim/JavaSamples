package Day20_160125;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "test.txt";
			FileInputStream fis = new FileInputStream(fileName);//바이트기반
			FileReader fr = new FileReader(fileName);//문자기반

			int data = 0;
			// fileInputStream을 이용해서 파일내용을 읽어 화면에 출력한다.
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);//바이트기반이므로 꺠져서출력
			}
			System.out.println();
			fis.close();

			// FileReader를 이용해서파일내용을 읽어 화면에 출력한다.
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);//문자기반이므로 한글이 깨지지않는다.
			}
			System.out.println();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main
}
