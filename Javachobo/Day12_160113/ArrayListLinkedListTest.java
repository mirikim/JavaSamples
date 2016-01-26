package Day12_160113;

import java.util.*;

public class ArrayListLinkedListTest {
	public static void main(String[] args) {
		// 추가할 데이터의 개수를 고려하여 충분히 잡아야한다.
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();

		System.out.println("= 순차적으로 추가하기 =");// Arr이 Linked보다 빠름
		System.out.println("ArrayList : " + add1(al));
		System.out.println("LinkedList : " + add1(ll));

		System.out.println();
		System.out.println("= 중간에 추가하기 =");// Linked가 Arr보다 빠름
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add1(ll));

		System.out.println();
		System.out.println("= 중간에 삭제하기 =");// Linked가 Arr보다 빠름
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll));

		System.out.println();
		System.out.println("= 순차적으로 삭제하기 =");// Arr가 Linked보다 빠름
		System.out.println("ArrayList : " + remove1(al));
		System.out.println("LinkedList : " + remove1(ll));

	}

	public static long add1(List al) {
		long start = System.currentTimeMillis();// 현재시간을 Millisecond단위로
												// 출력(1Milli = 1/1000)
		for (int i = 0; i < 100000; i++)
			al.add(i + "");// add()배열에 요소 추가
		long end = System.currentTimeMillis();
		return end - start;// 경과시간 return
	}

	public static long add2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.add(500, "X");// index[500]에 값을 X로 저장
		} // add를 1000번 반복하면서 index[500]에 X를 1000번저장함으로 500-1499까지 X로 저장됨
			// 따라서 list의 사이즈가 11000된다.

		long end = System.currentTimeMillis();
		return end - start;
	}

	public static long remove1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size() - 1; i > 0; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static long remove2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
