package Day15_160118;

import java.util.*;

public class GenericsEx2 {
	public static void main(String[] args) {
		ArrayList<Student_generics> list = new ArrayList<Student_generics>();
		list.add(new Student_generics("자바왕", 1, 1));
		list.add(new Student_generics("자바짱", 1, 2));
		list.add(new Student_generics("홍길동", 2, 1));
		list.add(new Student_generics("전우치", 2, 2));

		Iterator<Student_generics> it = list.iterator();
		while (it.hasNext()) {
			Student_generics s = it.next();
			System.out.println(s.name);
		}
	}// main
}

class Student_generics{
	String name = "";
	int ban;
	int no;

	Student_generics(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}
