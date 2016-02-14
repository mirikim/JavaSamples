package HomeWorkhb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class test {
	final static int REDCORD_NUM = 100;// 생성할 레코드의 수를 정한다.
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = { "010", "011", "017", "018", "019" };
	final static String[] CODE2 = { "남자", "여자" };
	final static String[] CODE3 = { "10대", "20대", "30대", "40대", "50대" };
	static ArrayList Database = new ArrayList(100);

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		for (int i = 0; i < REDCORD_NUM; i++) {
			String data = "INSERT INTO " + TABLE_NAME + " VALUES(" + " '" + getRandArr(CODE1) + "'" + ", '"
					+ getRandArr(CODE2) + "'" + ", '" + getRandArr(CODE3) + "'" + ", " + getRand(100, 200) + ");";
			// 100~200사이의 값을 얻는다.
			Database.add(data);
		}

		// String data = "대한민국";
		OutputStreamWriter osw = null;
		osw = new OutputStreamWriter(new FileOutputStream("20160212.txt"), "UTF-8");
		try {
			for (int i = 0; i < REDCORD_NUM; i++) {
				osw.write(Database.get(i) + "");
			}
		} catch (IOException ioe)

		{
			ioe.printStackTrace();
		} finally

		{
			if (osw != null)
				try {
					osw.close();
				} catch (Exception e) {
				}
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