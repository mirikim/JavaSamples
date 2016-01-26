package Day11_160112;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector v = new Vector<>(5);// 용량(capacity)이 5인 vector를 생성
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);

		v.trimToSize(); // 빈 공간을 없앤다(용량과 크기가 같아진다.)
		System.out.println("=== After trimToSize() ===");
		print(v);

		v.ensureCapacity(6);//Capacity가 6 이상 되도록 늘린다.
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);

		v.setSize(7);//size가 7이 되게 한다. 증가될 size가 capacity보다크면 capacity의 값을 2배 증가시켜준다.
		System.out.println("=== After setSize(7) ===");
		print(v);

		v.clear();//Vector에 저장된 모든 요소를 제거한다.
		System.out.println("=== After clear() ===");
		print(v);

	}

	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
}
