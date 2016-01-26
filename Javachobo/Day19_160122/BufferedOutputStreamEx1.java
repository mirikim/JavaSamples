package Day19_160122;

import java.io.*;

public class BufferedOutputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");

			// BufferedOutputStream의 버퍼 크기를 5로한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

			// 파일123.txt에 1부터 9까지 출력
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i); //9까지 쓰려고하지만 bos의크기는 5이므로 12345만 입력됨
			}
			//bos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}