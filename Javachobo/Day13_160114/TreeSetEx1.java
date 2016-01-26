package Day13_160114;

import java.util.*;

public class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();

		String from = "b";
		String to = "d";
		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");

		System.out.println(set);// 아스키코드순으로 정렬
		// 출력 : [Car, abc, alien, bat, car, dZZZZ, dance, disc, dzzzz, elephant,
		// elevator, fan, flower]
		System.out.println("range search : from " + from + " to " + to);
		System.out.println("result1 : " + set.subSet(from, to));
		// subSet(from,to);범위 검색 from(b)부터 to(d)까지인데 끝범위인 to의범위는 포함안함.

		System.out.println("reuslt2 : " + set.subSet(from, to + "zzz"));
		// subSet(from,to+"zzz);범위 검색 from(b)부터 to(d)+"zzz[=>dzzz]까지인데 끝범위인
		// dzzz의범위는 포함안함.
	}
}
