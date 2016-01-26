package Day13_160114;

import java.util.*;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));//김자바 key값 중복이므로 value값 100으로 90덮는다.
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));

		Set set = map.entrySet();//key와 value를 동시에 갖고오는 메서드 entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		set = map.keySet();//key값만 갖고오는 메서드 keySet();
		System.out.println("참가자 명단 : " + set);

		Collection values = map.values();//Value값만 갖고오는 메서드 .values();
		it = values.iterator();

		int total = 0;
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			total += i.intValue();
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float) total / set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
