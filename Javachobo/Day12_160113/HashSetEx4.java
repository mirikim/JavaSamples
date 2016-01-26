package Day12_160113;

import java.util.HashSet;

public class HashSetEx4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add(new String("abc"));// 중복허용x
		set.add(new String("abc"));
		set.add(new Person2("David", 10));// 중복허용o
		set.add(new Person2("David", 10));

		System.out.println(set);// set.toString();메소드를 호출한것과 같음
	}
}

class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person2) {
			Person2 tmp = (Person2) obj;
			return name.equals(tmp.name) && age == tmp.age; // name과 age가 모두 같으면
															// 같은 객체로 취급하겠다.
		}
		return false;
	}

	public int hashCode() {
		return name.hashCode() + age;// String클래스의 hashCode()를통해 중복된 값에 같은
										// hashCode를 부여함으로써 중복을 막는다.
	}

	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + age;
	}
}
