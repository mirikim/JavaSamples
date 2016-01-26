package Day13_160114;

import java.util.*;

public class ComparatorEx1 {
	public static void main(String[] args) {
		TreeSet set1 = new TreeSet();
		TreeSet set2 = new TreeSet(new Descending());// TreeSet(Comparator c)

		int[] score = { 30, 50, 10, 20, 40 };

		for (int i = 0; i < score.length; i++) {
			set1.add(new Integer(score[i]));
			set2.add(new Integer(score[i]));
		}
		System.out.println("set1 : " + set1);
		System.out.println("set2 : " + set2);
	}
}

class Descending implements Comparator {//다형성
	public int compare(Object o1, Object o2) {
		//Comparable는 비교하는 값이 크면 -1 같으면 0 작으면 1을 반환
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			//compareTo라는 메소드로 비교햐기위해 Compareable인터페이스타입인지확인
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
			// 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
		}
		return -1;
	}
}
