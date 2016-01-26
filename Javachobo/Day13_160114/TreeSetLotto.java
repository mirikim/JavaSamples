package Day13_160114;

import java.util.*;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;// Math.random()으로 얻을수 있는
														// 값의 범위 : 0 이상 1 미만
			set.add(new Integer(num));
		}
		System.out.println(set);
	}
}
