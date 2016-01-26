package Day12_160113;

import java.util.*;

public class HashSetEx {
	public static void main(String[] args) {
		Object[] objArr = { "1", "4", new Integer(1), "2",  "3", "3", "4", "2","4" };

		Set set = new HashSet();

		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);// HashSet에 objArr의 요소들을 저장한다.
		} // HashSet은 중복허용x,순서유지x

		System.out.println(set);// HashSet에 저장된 요소들을 출력
	}// 출력값 : [1,1,2,3,4] => 문자열1과 ,Integer type의 1은 다른 객체이므로 1이두번출력됨

}
