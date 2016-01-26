package Day9_160108;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExceptionEx13 {
	public static void main(String[] args) {
		PrintStream ps = null;// 파일 error.log에 출력할 준비를 한다.
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("error.log");
			ps = new PrintStream(fos);//보조 스트림

			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0 / 0);// 예외발생
			System.out.println(4);// 실행되지 않는다.

		} catch (Exception ae) {
			ae.printStackTrace(ps);
			ps.println("예외메시지 : " + ae.getMessage());// 화면대신 error.log에 저장

		} // try-catch의 끝
		System.out.println(6);
	}// main메서드의끝
}
