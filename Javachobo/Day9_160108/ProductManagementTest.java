package Day9_160108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수

	int tvInputNum, comInputNum, audioInputNum;// 입고수량

	static int tvStock;
	static int comStock;
	static int audioStock;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}

	Product() {

		tvStock = 100; // 수량의 초기재고
		comStock = 100;
		audioStock = 100;

	}

}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}

class Buyer { // 고객, 물건을 사는 사람
	int money = 1000; // 소유금액
	int bonusPoint = 0; // 보너스점수
	Vector item = new Vector(); // 구입한 제품을 저장하기 위한 배열

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}

		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
		item.add(p); // 제품을 Product[] item에 저장한다.
		// System.out.println(p + "을/를 구입하셨습니다.");
		// System.out.println("소유금액 : " + money + "만원 ,보너스점수 : " + bonusPoint);

	}

	void refund(Product p) {// 구입한 제품을 환불한다.
		if (item.remove(p)) {// 제품을 Vector에서 제거한다.
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
			System.out.println("");
		} else {// 제거에 실패한경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}

	void summary() {// 구매한 물품에 대한 정보를 요약해서 보여 준다.
		int sum = 0;// 구입한 물품의 가격합계
		String itemList = "";// 구입한 물품목록
		// 반목문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.

		if (item.isEmpty()) {// Vector가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
			System.out.println("");
			return;
		}
		// Vector의 i번째에 있는 객체를 얻어온다.
		for (int i = 0; i < item.size(); i++) {
			Product p = (Product) item.get(i);
			sum += p.price;
			itemList += (i == 0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

class ProductManagementTest {
	public static void main(String args[]) {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		Product p = new Product();

		Buyer b = new Buyer();

		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audio = new Audio();

		System.out.println("===============================프로그램 시작=================================");
		Loop_menu: while (true) {
			System.out.println("");
			System.out.println("                            < 메뉴 선택> ");
			System.out.println("1 : 상품입고,  2 : 구매, 3 : 상품재고, 4 : 구매내역, 5 : 반품 , 6 : 종료 ");
			System.out.print("메뉴를 선택하세요. : ");

			int programNum = s.nextInt();
			switch (programNum) {
			case 1:
				Loop_inputItem: while (true) {
					System.out.println("입고 상품을 선택해 주세요 tv : '1' , computer : '2' , audio : '3' , 입고종료 : '4'");
					int itemNum = s.nextInt();

					switch (itemNum) {
					case 1:
						System.out.print("tv 입고량 입력: ");
						p.tvInputNum = s.nextInt();
						p.tvStock += p.tvInputNum;
						System.out.println("tv 재고량 :  " + p.tvStock + "개");
						break;

					case 2:
						System.out.print("computer 입고량 입력: ");
						p.comInputNum = s.nextInt();
						p.comStock += p.comInputNum;
						System.out.println("computer 재고량 :  " + p.comStock + "개");
						break;

					case 3:
						System.out.print("audio 입고량 입력: ");
						p.audioInputNum = s.nextInt();
						p.audioStock += p.audioInputNum;
						System.out.println("audio 재고량 :  " + p.audioStock + "개");
						break;
					case 4:// 입고종료
						break Loop_inputItem;
					default:
						System.out.println("해당 항목이 없습니다.");
						break;
					}
				}
				break; // Loop_inputItem 끝

			case 2:
				Loop_buyItem: while (true) {

					System.out.println("구매하실 제품을 선택해주세요.  tv : '1' , computer : '2' , audio : '3' , 구매종료 : '4'");

					int buyItemNum = s.nextInt();
					switch (buyItemNum) {
					case 1:
						p.tvStock -= 1;
						if (p.tvStock > 0) {
							b.buy(tv);
							System.out.println("Tv를 구입하셨습니다.");
							System.out.println("소유금액 : " + b.money + "만원 ,보너스점수 : " + b.bonusPoint);
						} else if (p.tvStock <= 0) {
							System.out.println("Tv 재고가 없습니다");
							break;
						}
						break;

					case 2:
						p.comStock -= 1;
						if (p.comStock > 0) {
							b.buy(com);
							System.out.println("Computer를 구입하셨습니다.");
							System.out.println("소유금액 : " + b.money + "만원 ,보너스점수 : " + b.bonusPoint);

						}

						else if (p.comStock <= 0) {
							System.out.println("computer 재고가 없습니다");
							break;
						}
						break;

					case 3:
						p.audioStock -= 1;
						if (p.audioStock > 0) {
							b.buy(audio);
							System.out.println("Audio를 구입하셨습니다.");
							System.out.println("소유금액 : " + b.money + "만원 ,보너스점수 : " + b.bonusPoint);

						} else if (p.audioStock <= 0) {
							System.out.println("audio 재고가 없습니다");
							break;
						}
						break;
					case 4:// 구매종료
						break Loop_buyItem;
					default:
						System.out.println("해당제품이 없습니다.");

					}

				}
				break;// Loop_buyItem종료
			case 3:

				System.out.println("=============================== 상품 재고량 =================================");
				System.out.println("");
				System.out
						.println("Tv : " + p.tvStock + "개 , Computer : " + p.comStock + "개 , Audio : " + p.audioStock);
				System.out.println("");
				break;
			case 4:
				System.out.println("");
				System.out.println("=============================== 구매 내역 =================================");
				b.summary();
				System.out.println("");
				break;
			case 5:
				System.out.println(" ");
				System.out.println("=============================== 제품 반품 =================================");
				Loop_refund: while (true) {
					System.out.println("반품할 상품번호를 입력해주세요.   tv : '1' , computer : '2' , audio : '3' , 반품종료 : '4'");
					int refundNum = s.nextInt();
					switch (refundNum) {
					case 1:
						b.refund(tv);
						break;

					case 2:
						b.refund(com);
						break;

					case 3:
						b.refund(audio);
						break;
					case 4:// 반품종료
						break Loop_refund;
					default:
						System.out.println("해당 상품이 구매내역에 없습니다.");
					}
				}

				break;

			case 6:// 프로그램종료

				break Loop_menu;
			}
		}
		System.out.println("===============================프로그램 종료=================================");
	}

}
