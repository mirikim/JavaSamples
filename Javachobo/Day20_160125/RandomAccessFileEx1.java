package Day20_160125;

import java.io.*;

public class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");// rw
																			// :�а���
																			// ���
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());
			// getFilePointer() :������ �����͸� �о�������� �������� ��ġ�� ������ �޼���
			raf.writeInt(100);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());
			raf.writeLong(100L);
			System.out.println("���� �������� ��ġ : " + raf.getFilePointer());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
