package HomeWork;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class DatabaseInputTest {

	// final static int REDCORD_NUM = 200;// ������ ���ڵ��� ���� ���Ѵ�.
	final static int REDCORD_cusNum = 100;
	final static int REDCORD_productNum = 100;
	final static String[] CUS_NAME = { "���ҿ�", "��̸�", "������", "������", "�켺��", "�ڻ���", "������", "������", "������", "����ȯ", "������",
			"������", "�̼���", "������", "������", "������" };
	final static String[] SEX = { "m", "f" };
	static ArrayList Database_cus = new ArrayList(100);
	static ArrayList Database_product = new ArrayList(100);

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		for (int i = 0; i < REDCORD_cusNum; i++) {
			String data_customer = "INSERT INTO customer VALUES(" + getRand(2, 200) + ", '" + getRandArr(CUS_NAME) + "'"
					+ ", '" + getRandArr(SEX) + "'" + ", '" + getEmail() + "'" + ", '" + getPhoneNo() + "'" + ", '"
					+ getBirth(1970, 1995) + "');";
			String enter = "\n";

			Database_cus.add(data_customer);
			Database_cus.add(enter);
		}

		for (int i = 0; i < REDCORD_productNum; i++) {
			String data_product = "INSERT INTO product VALUES(" + getRand(2, 200) + getProduct() + ");";
			String enter = "\n";

			Database_product.add(data_product);
			Database_product.add(enter);
		}

		OutputStreamWriter osw = null;
		osw = new OutputStreamWriter(new FileOutputStream("a.sql"), "UTF-8");
		try {
			for (int i = 0; i < REDCORD_cusNum; i++) {
				osw.write(Database_cus.get(i) + "");
			} // customer Data input
			for (int i = 0; i < REDCORD_productNum; i++) {
				osw.write(Database_product.get(i) + "");
			} // product Data input

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

	public static String getProduct() {
		String[] maker = { "���", "���ѱ�", "�︳", "���", "����", "����", "����", "�鼳" };
		String[] category = { "����", "Ŀ��", "���", "���̽�ũ��", "����", "�꽺", "���ݸ�" };
		String[] adjective = { "���ִ�", "�ǰ���", "���ǰ���", "�ڿ���", "�ڿ�����", "���", "���", "�����", "������", "������" };
		String[] price = { "1000", "1200", "1500", "1800", "2000", "2300", "2600" };

		String new_category = getRandArr(category);
		String new_name = getRandArr(adjective) + new_category;
		return ",'"+new_name + "', '" + getRandArr(maker) + "', '" + new_category + "', '" + getRandArr(price) + "'";
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

	public static String getEmail() {
		String NUMBER = "0123456789";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String[] mail = { "@naver.com", "@nate.com", "@gmail.com", "@hanmail.com" };
		String id = null;
		for (int i = 0; i < 8; i++) {
			int j = (int) Math.random() * 2;
			if (i == 0) {
				id += NUMBER.charAt((int) (Math.random() * 10));
			} else if (i == 1) {
				id += alphabet.charAt((int) (Math.random() * 26));
			}
		} // ����8��id����
		String new_email = id + getRandArr(mail);

		return new_email;
	}

	public static String getBirth(int from, int to) {
		int month, year, day;
		String new_date = null;
		Random call = new Random();
		month = call.nextInt(11);
		year = (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
		day = call.nextInt(30);

		String now = year + "-" + month + "-" + day;

		// SimpleDateFormat�� ������ �����Ѵ�.
		SimpleDateFormat original_format = new SimpleDateFormat("yyyy-M-d");
		SimpleDateFormat new_format = new SimpleDateFormat("yyyy-MM-dd");

		// ��¥ ���� ��ȯ�� �Ľ� ������ try.. catch..�� üũ�Ѵ�.
		try {
			// ���ڿ� Ÿ���� ��¥ Ÿ������ ��ȯ�Ѵ�.
			Date original_date = original_format.parse(now);

			// ��¥ ������ ���ϴ� Ÿ������ �����Ѵ�.
			new_date = new_format.format(original_date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new_date;

	}

	public static String getPhoneNo() {
		String PhoneNo = "010-" + getRand(1000, 9999) + "-" + getRand(1000, 9999);

		return PhoneNo;

	}
}