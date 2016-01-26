package Day12_160113;

import java.util.*;

public class HashSetEx2 {
	public static void main(String[] args) {
		Object[] objArr = { "1", "4", new Integer(1), "2",  "3", "3", "4", "2","4" };
		Set set = new LinkedHashSet<>();// HashSet대신 LinkedHashSet을 사용한다.
		// LinkedHashSet ->중복허용x,순서유지o
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);
		}
		System.out.println(set);
	}
}
