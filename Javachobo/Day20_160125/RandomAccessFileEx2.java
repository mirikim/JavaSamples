package Day20_160125;

import java.io.*;

public class RandomAccessFileEx2 {
	public static void main(String[] args) {
		// ��ȣ,����,����,����
		int[] score = { 1, 100, 90, 90, 
				2, 70, 90, 100, 
				3, 100, 10, 100, 
				4, 70, 60, 80, 
				5, 70, 90, 100 };
		int sum = 0;
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
			for (int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			}
			while (true) {
				System.out.println(raf.readInt());
			}
		} catch (EOFException eof) {
			// radInt()�� ȣ������ �� �� �̻� ���� ������ ������ EOFException�� �߻��Ѵ�.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main
}