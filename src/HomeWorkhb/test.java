package HomeWorkhb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class test {
	final static int REDCORD_NUM = 100;// ������ ���ڵ��� ���� ���Ѵ�.
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = { "010", "011", "017", "018", "019" };
	final static String[] CODE2 = { "����", "����" };
	final static String[] CODE3 = { "10��", "20��", "30��", "40��", "50��" };
	static ArrayList Database = new ArrayList(100);

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		for (int i = 0; i < REDCORD_NUM; i++) {
			String data = "INSERT INTO " + TABLE_NAME + " VALUES(" + " '" + getRandArr(CODE1) + "'" + ", '"
					+ getRandArr(CODE2) + "'" + ", '" + getRandArr(CODE3) + "'" + ", " + getRand(100, 200) + ");";
			// 100~200������ ���� ��´�.
			Database.add(data);
		}

		// String data = "���ѹα�";
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
		return arr[getRand(arr.length - 1)];// �迭�� ����� �� �� �ϳ��� ��ȯ�Ѵ�.
	}

	public static int getRand(int n) {
		return getRand(0, n);
	}

	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}
}