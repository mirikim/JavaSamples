package Day20_160125;

import java.io.*;

public class RandomAccessFileEx3 {
	public static void main(String[] args) {
		int sum = 0;

		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
			int i = 4;

			while (true) {
				raf.seek(i);
				sum += raf.readInt();//국어점수의합
				i += 16; 
			}
		} catch (EOFException e) {
			System.out.println("sum : " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
