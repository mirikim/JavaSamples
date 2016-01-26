package Day13_160114;

import java.util.*;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("castello", "1234");// Key,value
		map.put("asdf", "1111");//Key는 중복될수없다.
		map.put("asdf", "1234");//map.put("asdf", "1111");를 map.put("asdf", "1234");가 덮게된다.

		Scanner s = new Scanner(System.in);// 화면으로부터 라인단위로 입력받는다.

		while (true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id : ");
			String id = s.nextLine().trim();

			System.out.print("password : ");
			String password = s.nextLine().trim();
			System.out.println();

			if (!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;

			} else {
				if (!(map.get(id)).equals(password)) {
					//map에 Key값인 id를 입력하면 Value값을 가져온다. 그값이 password로 입력된 값과 같은지 비교(equals)
					System.out.println("password가 일치하지 않습니다. 다시 입력해주세요.");
				} else {
					System.out.println("id와 password가 일치합니다.");

					break;
				}
			}
		} // while
	}// main
}
