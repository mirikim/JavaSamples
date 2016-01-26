package Day13_160114;

import java.util.*;

public class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };

		HashMap map = new HashMap();
		for (int i = 0; i < data.length; i++) {
			if (map.containsKey(data[i])) {// map에 중복된 값이 있는지 확인
				Integer value = (Integer) map.get(data[i]);// 중복된 값이 있으면
															// intValue()의 값을 증가
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = ((Integer) entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
	}// main

	public static String printBar(char ch, int value) {
		char[] bar = new char[value];

		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);// String(char[] chArr)
	}
}
