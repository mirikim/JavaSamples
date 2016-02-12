package HomeWorkhb;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class RandomEx4 {
	final static int REDCORD_NUM = 10;// 생성할 레코드의 수를 정한다.
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = { "010", "011", "017", "018", "019" };
	final static String[] CODE2 = { "남자", "여자" };
	final static String[] CODE3 = { "10대", "20대", "30대", "40대", "50대" };

	public static void main(String[] args) {
		for (int i = 0; i < REDCORD_NUM; i++) {
			System.out.println("INSERT INTO " + TABLE_NAME + " VALUES(" + " '" + getRandArr(CODE1) + "'" + ", '"
					+ getRandArr(CODE2) + "'" + ", '" + getRandArr(CODE3) + "'" + ", " + getRand(100, 200) + ");");
			// 100~200사이의 값을 얻는다.
		}
		try {
			FileOutputStream fos = new FileOutputStream("exampleData.txt");

			// BufferedOutputStream의 버퍼 크기를 5로한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

			
			for (int i = 0; i < REDCORD_NUM; i++) {
				bos.write(i);
			}
			bos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getRandArr(String[] arr) {
		return arr[getRand(arr.length - 1)];// 배열에 저장된 값 중 하나를 반환한다.
	}

	public static int getRand(int n) {
		return getRand(0, n);
	}

	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}
}
