package Day11_160112;

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */

		// 교집합
		kyo.addAll(list1);// 배열kyo에 배열list1의 값을 전부 저장한다.
		kyo.retainAll(list2);// kyo와 list2가 둘다 갖고 있는 값만 저장 =>교집합

		// 차집합
		cha.addAll(list1); // 배열cha에 배열list1의 값을 전부 저장한다.

		for (int i = cha.size() - 1; i >= 0; i--) {
			if (kyo.contains(cha.get(i)))// kyo에있는 값을 cha가 갖고있으면 cha의값을
											// remove한다.=>차집합.
				cha.remove(i);
		}

		// 합집합
		hap.addAll(list1);// 배열hap에 배열 list1의 값을 전부 저장한다.
		for (int j = hap.size() - 1; j >= 0; j--) {
			if (kyo.contains(hap.get(j)))
				hap.remove(j); // kyo에있는 값을 hap이 갖고있으면 hap의 값을 지운다. =>교집합제거
		}
		hap.addAll(list2);// list1과 list2의 교집합을 제거한 hap배열에 list2의 값을 전부 저장
		
//		hap.addAll(cha);
//		hap.addAll(list2); //2줄로 위의 합집합을 구현할 수 있다.

		System.out.println("list1=" + list1); // 1, 2, 3, 4
		System.out.println("list2=" + list2); // 3, 4, 5, 6
		System.out.println("kyo=" + kyo); // 3, 4
		System.out.println("cha=" + cha); // 1, 2
		System.out.println("hap=" + hap); // 1, 2, 3, 4, 5, 6
	}
}
