package Day20_160125;

import java.io.*;

public class StandardIOEx1 {
	public static void main(String[] args) {
		try {
			
			int input = 0;
			while ((input = System.in.read()) != -1) {//read()메서드는 내부적으로 버퍼를 갖고있다.
				
				System.out.println("input : " + input + ", (char)input : " + (char) input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main
}
