package Day14_160115;

import java.util.*;
import java.io.*;

public class RandomEx6 {

	public static Properties prop = new Properties();
	public static String fileName = "data.txt";

	public static void main(String[] args) {
		String[] data = readData();
		HashMap map = new HashMap();
		for (int i = 0; i < 100; i++) {
			String temp = getRandArr(data);
			if (map.containsKey(temp)) {
				Integer value = (Integer) map.get(temp);
				map.put(temp, new Integer(value.intValue() + 1));
			} else {
				map.put(temp, new Integer(1));
			}
		}
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			Integer value = (Integer) map.get(key);
			int intValue = value.intValue();
			System.out.println(key + " : " + printGraph('#', intValue) + intValue);
		}
	}

	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
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

	public static String[] readData() {
		try {
			prop.load(new FileInputStream(fileName));//.load() = property list를 읽는 메소드
		} catch (IOException e) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		Enumeration e = prop.propertyNames();//.propertyNames(); 목록의 모든 Key를 꺼내오는 메서드
		//A B C D 가 저장되어있다.

		int sum = 0;
		// 각 요소의 값을 더해서 요소들을 담을 배열의 크기를 결정한다.
		while (e.hasMoreElements()) {//다음에 읽어올 element가 있는지 체크!
			String element = (String) e.nextElement();//다음에있는 element를 가져와서 String element에 저장
			int value = Integer.parseInt(prop.getProperty(element));//element의 Value값을 받아서 int value에저장
			sum += value;
			System.out.println(element + " = " + value);
		}
		
		String[] data = new String[sum];
		// 생성한 배열에 각 요소의 값 만큼 요소를 채운다.
		// 예를 들어 A=1,B=2,C=3이라면
		// String[]data ={"A","B","B","C","C","C"};와 같이 되는 셈이다.
		
		
		int i = 0;
		e = prop.propertyNames();// Enumeration을 다시얻어와야한다.

		while (e.hasMoreElements()) {
			String element = (String) e.nextElement();
			int value = Integer.parseInt(prop.getProperty(element));

			for (int x = 0; x < value; x++, i++) {
				data[i] = element;
			}
		} // while(e.hasMoreElements()){
		return data;

	}
}
