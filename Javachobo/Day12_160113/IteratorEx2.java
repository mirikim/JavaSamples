package Day12_160113;

import java.util.*;

public class IteratorEx2 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);

		for (int i = 0; i < 10; i++) {
			original.add(i + "");
		}
		Iterator it = original.iterator();//인터페이스객체는사용할때 마다 선언해줘야한다.

		while (it.hasNext()) {
			copy1.add(it.next());
		}
		
		System.out.println("= Original에서 copy1로 복사(copy) =");
		System.out.println("original: " + original);
		System.out.println("copy1 : " + copy1);
		System.out.println();

		it = original.iterator();//인터페이스객체는사용할때 마다 선언해줘야한다.

		while (it.hasNext()) {// it에 저장된 값이 있는 동안 계속 반복
			copy2.add(it.next());// original에 있는 값 copy2에 저장
			it.remove();//remove는 it에 저장된 원본값(original)까지 다 지워버린다.
			// origianl에 맨앞에 저장되있는 값 remove
			// ==>original에서 copy2로 이동한 것처럼 보임
		}
		System.out.println("= Original에서 copy2로 이동(move) =");
		System.out.println("original : " + original);
		System.out.println("copy2 : " + copy2);

	}// main
}// class
