package Day19_160122;

import java.io.*;
import java.util.Arrays;

public class IOEx3 {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] temp = new byte[4];// 이전 예제와 배열으 ㅣ크기가 다르다.

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		try {
			while (input.available() > 0) {
				int length = input.read(temp);
				output.write(temp, 0, length);
				// Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
				// *************************************************
				// input.read(temp);
				// output.write(temp);//Output Source : [0, 1, 2, 3, 4, 5, 6, 7,
				// 8, 9,6,7]
				System.out.println("temp : " + Arrays.toString(temp));
			}
		} catch (IOException e) {
		}

		outSrc = output.toByteArray();

		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		System.out.println("temp          : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
}
