package Day8_160107;

import java.util.Vector;

class Buyer3 {// 고객,물건을 사는사람
	int money = 1000;// 소유금액
	int bounusPoint = 0;// 보너스점수

	Vector item = new Vector();// 구입한 제품을 저장하는데 사용될 Vector 객체
								// 벡터는 10개의 객체를 저장할 수 있다. 10개이상의 인스턴스가 저장되면
								// 자동적으로 크기가 증가된다.

	void buy(Product2 p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bounusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "을/를 구입하셨습니다.");
	}

	void refund(Product2 p) {// 구입한 제품을 환불한다.
		if (item.remove(p)) {// 제품을 Vector에서 제거한다.
			money += p.price;
			bounusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		} else {// 제거에 실패한경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}

	void summary() {// 구매한 물품에 대한 정보를 요약해서 보여 준다.
		int sum = 0;// 구입한 물품의 가격합계
		String itemList = " ";// 구입한 물품목록
		// 반목문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.

		if (item.isEmpty()) {// Vector가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		// Vector의 i번째에 있는 객체를 얻어온다.
		for (int i = 0; i < item.size(); i++) {
			Product2 p = (Product2) item.get(i);
			sum += p.price;
			itemList += (i == 0) ? " " + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

public class PolyArgumentTest3 {
	public static void main(String[] args) {
		Buyer3 b = new Buyer3();
		Tv2 tv = new Tv2();
		Computer2 com = new Computer2();
		Audio audio = new Audio();

		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();

		b.refund(com);
		b.summary();
	}
}
