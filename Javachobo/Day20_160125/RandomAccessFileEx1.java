package Day20_160125;

import java.io.*;

public class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");// rw
																			// :읽고쓰기
																			// 모드
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			// getFilePointer() :파일의 데이터를 읽어오기위한 포인터의 위치를 얻어오는 메서드
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
