package Day11_160112;

import java.util.*;

public class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));

		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // list1의 index
																// 1부터 4전까지
																// list2에저장
		print(list1, list2);// list1,list2출력

		Collections.sort(list1);// list1과 list2를 정렬한다.(순서대로)
		Collections.sort(list2);// Collections.sort(List 1);
		print(list1, list2);// list1,list2출력

		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		// list1가 list2의 배열요소들을 다 포함하므로 true (하나라도 포함하지 않으면 false)

		list2.add("B");// list2 배열요소에 B와 C를 추가
		list2.add("C");
		list2.add(3, "A");// list2 배열요소의 index3에 A를 추가
		print(list1, list2);// list1,list2출력
		list2.set(3, "AA");// list2 배열요소의 index3에 AA를 저장
		print(list1, list2);// list1,list2출력

		// list1에서 list2에 있는 값만 남기고 나머지는삭제한다. -->삭제성공 : true/ 삭제실패 : false
		System.out.println("list.retainAll(list2) : " + list1.retainAll(list2)); // list1에서
																					// list2와
																					// 겹치는부분인(0,2,4)만
																					// list1에
																					// 저장
		print(list1, list2);// list1,list2출력

		// list2에서 list1에 포함된 객체들을 삭제한다.
		// list2 : [0, 2, 4, AA, B, C]에서 list1에 포함된 [0, 2, 4]를 제거 =>list2 : [AA,
		// B, C]
		for (int i = list2.size() - 1; i >= 0; i--) {// 배열의 뒷부분부터 삭제 (앞에서 삭제하면
														// 배열의 요소들을 하나씩 이동해야하는
														// 부담이있기때문)
			if (list1.contains(list2.get(i)))// contains를 확인하고 remove를 한다.
				list2.remove(i);
		}
		print(list1, list2);// list1,list2출력
	}// main

	static void print(ArrayList list1, ArrayList list2) {// parameter
															// list1,list2를
															// 출력해주는 메서드
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}// class
