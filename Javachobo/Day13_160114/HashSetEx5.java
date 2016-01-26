package Day13_160114;

import java.util.*;

public class HashSetEx5 {
	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();

		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		System.out.println("A = " + setA);

		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("B = " + setB);

		Iterator it = setB.iterator();// Iterator객체는 일회용! 사용할때마다 선언해줘야한다.

		// hasNext는 읽어올 다음요소가 있는지 없는지 확인
		while (it.hasNext()) {// 교집합 구하는 메서드 retainAll()이있다.
			Object tmp = it.next();// next는 다음요소를 읽어옴.
			if (setA.contains(tmp))// setA가 setB를 iterator한 tmp의 값을 갖고있다면
				setKyo.add(tmp);// 조건문을 만족한tmp의 값을 setKyo에 저장한다.
		}

		it = setA.iterator();// Iterator객체는 일회용! 사용할때마다 선언해줘야한다.
		while (it.hasNext()) {// hasNext는 읽어올 다음요소가 있는지 없는지 확인
			Object tmp = it.next();// next는 다음요소를 읽어옴.
			if (!setB.contains(tmp))// setB가 setA를 iterator한 tmp의 값을 갖고있지 않다면
				setCha.add(tmp);// 조건문을 만족한 tmp의 값을 setCha에저장한다.
		}

		it = setA.iterator();
		while (it.hasNext())
			setHab.add(it.next());

		it = setB.iterator();
		while (it.hasNext())
			setHab.add(it.next()); //Set은 중복을 허용하지 않는다. 따라서 setA와 setB자동으로 공통된 값을 걸러준다.

		System.out.println("A ∩ B = " + setKyo);
		System.out.println("A ∪ B = " + setHab);
		System.out.println("A - B = " + setCha);

	}
}
