package Day12_160113;

import java.util.*;

public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();
		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(new Integer(num));
		}
		// LinkedList의 파라미터는 Collection을 받는데 Collection인터페이스를 Set이 상속받기때문에
		// set을 파라미터로 받을 수 있다.
		List list = new LinkedList(set);// LinkedList(Collection c)
		// sort를 위해서 set의 형태를 List로 바꿔준다. sort의 파라미터는 list이므로
		Collections.sort(list);// Collections.sort(List list)
		System.out.println(list);
	}
}
