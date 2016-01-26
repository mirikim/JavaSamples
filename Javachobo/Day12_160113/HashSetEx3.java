package Day12_160113;

import java.util.*;

public class HashSetEx3 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add(new String("abc"));//중복허용x
		set.add(new String("abc"));
		set.add(new Person("David", 10));//중복허용o
		set.add(new Person("David", 10));

		System.out.println(set);//set.toString();메소드를 호출한것과 같음
	}
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + age;
	}
}
