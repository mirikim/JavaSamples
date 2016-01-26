package Day10_160111;

import java.io.IOException;
import java.util.Vector;

/* 
 * 추상 클래스로 인스턴스 생성 불가하며,
 *  Tv, Computer, Audio에서 상속 받는다.
 */
abstract class Product {
	enum Type {
		TV, COMPUTER, AUDIO
	} // 제품 종류 상수형

	final Type type; // 제품 종류 - final이라 생성자에서 초기화해준다
	int price; // 제품 가격

	Product(Type type) {
		this.type = type; // 인스턴스 변수 type 초기화
	}

	public String toString() { // 각 제품의 종류에 맞게 문자열을 반환한다.
		switch (type) {
		case TV:
			return "TV";
		case COMPUTER:
			return "COMPUTER";
		case AUDIO:
			return "AUDIO";
		default:
			return "NULL";

		}
	}

}

/*
 * Product 추상 클래스를 상속 받아서 값 초기화를 진행한다. 아래 코드는 Tv(int price) -> Tv() ->
 * Product(Product.Type 제품타입) 순서로 호출되어 생성된다. 다른 Computer, Audio 클래스도 같은 방식으로
 * 진행된다.
 */
class Tv extends Product {
	Tv() {
		super(Product.Type.TV);
	}

	Tv(int price) {
		this();
		this.price = price;
	}
}

class Computer extends Product {
	Computer() {
		super(Product.Type.COMPUTER);
	}

	Computer(int price) {
		this();
		this.price = price;
	}
}

class Audio extends Product {
	Audio() {
		super(Product.Type.AUDIO);
	}

	Audio(int price) {
		this();
		this.price = price;
	}
}

/*
 * 마트 창고를 의미하는 클래스로 추후 Mart 클래스에 포함된다.(Has-a관계) products라는 Product형을 담는 Vector를
 * 인스턴스 변수로 가진다. 입고(putProduct), 출고(getProduct), 출력(productsList) 하기 기능을 수행
 */
class MartWarehouse {

	Vector<Product> products = new Vector<Product>();
	// Vector와 Vector<Product>의 다른점은 Vector<Product>는
	// Product형(자손포함)만 담을 수 있다.(안전한 코딩을 위해 컴파일러가 체크해준다.)
	// 반면 그냥 Vector는 모든 데이터타입을 넣을수 있다.(기본형 포함)

	void putProduct(Product p) {
		products.add(p);
	} // 제품 추가 메소드로 메모리 초과를 제외하면 특별한 에러가 없을듯해서 예외처리 안함

	Product getProduct(int pIndex) throws Exception { // index에 맞는 Product를
														// Vector에서
														// 가져오기(Vector에서는 제거함)
		try {
			return products.remove(pIndex);
		} // pIndex에 있는 Product객체 반환
		catch (Exception e) {
			throw new Exception("잘못된 제품 번호를 선택하셨습니다.");
		} // 제거 실패 시 예외처리
	}

	void productsList() throws Exception { // products 벡터에 있는 것을 출력하는 메소드로 비어있지
											// 않으면 for문으로 돌며 출력
		if (products.isEmpty())
			throw new Exception("창고가 텅 비었습니다.");

		Product pTemp;
		for (int i = 0; i < products.size(); i++) {
			pTemp = products.get(i);
			System.out.println(i + ". 제품종류: " + pTemp + ",  가격: " + pTemp.price);
		}
	}
}

/*
 * Mart내에서 구매하는 사람의 객체이며 money라는 int형 인스턴스 변수와 inventory라는 Vector를 가진다.
 * MartWarehouse 클래스처럼 넣고(buy), 빼고(refund), 출력(inventoryList) 하는 기능을 수행
 */
class Buyer {
	int money = 1000; // 기본적으로 1000의 돈을 가지고 시작한다.
	Vector<Product> inventory = new Vector<Product>();

	void buy(Product p) throws Exception {
		if (p.price <= money) {
			inventory.add(p);
			money -= p.price;
			return;
		} else {
			throw new Exception("돈이 부족합니다."); // 돈이 부족할 때 예외 발생
		}
	}

	void refund(int index) throws Exception { // 환불 메소드
		try {
			Product pTemp = inventory.remove(index);
			money += pTemp.price;
		} catch (Exception e) {
			throw new Exception("잘못된 제품을 선택하셨습니다.");
		} // 범위 미만 또는 초과 제품번호 선택시 예외발생
	}

	void inventoryList() throws Exception { // 구매한 제품 목록 출력
		if (inventory.isEmpty())
			throw new Exception("구매한 제품이 없습니다.");

		Product pTemp;
		for (int i = 0; i < inventory.size(); i++) {
			pTemp = inventory.get(i);
			System.out.println(i + ".  제품종류: " + pTemp + ",  가격: " + pTemp.price);
		}
	}
}

/*
 * Mart 클래스에서 MartWarehouse와 Buyer를 포함한다.
 * 
 * 
 */
class Mart {
	MartWarehouse martWarehouse = new MartWarehouse();
	Buyer buyer = new Buyer();

	void martOpen() {
		while (true) {
			System.out.println("1. 매니저 모드");
			System.out.println("2. 고객 모드");
			System.out.println("3. 종료");
			System.out.print(" -> ");
			switch (getNumberFromKeyboard()) {
			case 1:
				managerMode();
				break;
			case 2:
				guestMode();
				break;
			case 3:
			default:
				return;
			}
		} // end of while
	}

	void managerMode() { // 메소드명 그대로 매니저가 할 일인 제품 추가 또는 재고 리스트 출력
		while (true) {
			System.out.println(" 1. 제품 추가");
			System.out.println(" 2. 재고 확인");
			System.out.println(" 3. 처음화면으로");
			System.out.print(" -> ");
			switch (getNumberFromKeyboard()) {
			case 1:
				putProductMode();
				break;
			case 2:
				try {
					martWarehouse.productsList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} // 비어있다면 예외발생
				break;
			case 3:
			default:
				return;
			}
		} // end of while
	}

	/*
	 * 추가할 Product 정보를 입력 받아 martWarehouse에 추가하는 메소드로 추가할 때 다형성(Polymorphism)을
	 * 이용한다. ( martWarehouse.putProduct(Product p) 부분 )
	 */
	void putProductMode() {

		System.out.println("   제품 종류는 무엇입니까?");
		System.out.println("   1. TV");
		System.out.println("   2. COMPUTER");
		System.out.println("   3. AUDIO");
		System.out.println("   4. 뒤로");
		System.out.print(" -> ");
		int pType = getNumberFromKeyboard();

		System.out.println("   제품 가격은 얼마입니까?");
		System.out.print(" -> ");
		int pPrice = getNumberFromKeyboard();

		switch (pType) {
		case 1:
			martWarehouse.putProduct(new Tv(pPrice)); // 다형성 이용
			break;
		case 2:
			martWarehouse.putProduct(new Computer(pPrice)); // 다형성 이용
			break;
		case 3:
			martWarehouse.putProduct(new Audio(pPrice)); // 다형성 이용
			break;
		case 4:
		default:
			System.out.println("제품이 추가에 실패했습니다.");
			return;
		}

		System.out.println("제품이 추가되었습니다.");

	}

	void guestMode() { // 메소드명 그대로 손님 기능
		while (true) {
			System.out.println("\n             Money:" + buyer.money); // 현재 소지
																		// 금액도
																		// 출력해준다.
			System.out.println(" 1. 제품 확인");
			System.out.println(" 2. 제품 구매");
			System.out.println(" 3. 구매제품 확인");
			System.out.println(" 4. 제품 환불");
			System.out.println(" 5. 처음화면으로");
			System.out.print(" -> ");
			switch (getNumberFromKeyboard()) {
			case 1:
				try {
					martWarehouse.productsList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				buyMode();
				break;
			case 3:
				try {
					buyer.inventoryList();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				refundMode();
				break;
			case 5:
			default:
				return;
			}
		} // end of while
	}

	void buyMode() {
		try {
			martWarehouse.productsList();
		} // 제품 목록을 출력 후
		catch (Exception e) {
			System.out.println(e.getMessage());
			return; // 창고가 비어있으면 종료
		}

		System.out.println("구입할 제품번호를 입력하세요.");
		System.out.print("  -> ");
		int pIndex = getNumberFromKeyboard(); // 제품 번호를 선택하여

		Product pTemp = null;
		try {
			pTemp = martWarehouse.getProduct(pIndex);
		} // 제품을 창고에서 가져와
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // 인덱스 벗어나면 예외 발생

		try {
			buyer.buy(pTemp);
		} // Buyer가 제품을 산다.
		catch (Exception e) {
			System.out.println(e.getMessage()); // 돈이 부족하면 예외 발생
			martWarehouse.putProduct(pTemp); // 다시 창고행
		}
	}

	void refundMode() {
		try {
			buyer.inventoryList();
		} // 구매한 제품리스트 출력 후
		catch (Exception e) {
			System.out.println(e.getMessage());
			return; // 구매한 제품이 없으면 종료
		}
		System.out.println("환불할 제품번호를 입력하세요.");
		System.out.print("  -> ");
		int pIndex = getNumberFromKeyboard(); // 제품 번호를 선택하여

		try {
			buyer.refund(pIndex);
		} // 환불한다.
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // 제품 번호 선택이 범위를 벗어나면 예외 발생
	}

	/*
	 * 키보드로부터 숫자입력을 받아들이는 메소드로 public static 메소드라 생성없이 어디서든 사용가능하다. 아무값도 입력 안된경우
	 * 0을 반환한다.
	 */
	public static int getNumberFromKeyboard() {
		String strTemp = "";
		char chTemp = '\u0000';

		while (chTemp != '\n') { // 엔터키(\r\n)가 아니면 계속 반복하여
			try {
				chTemp = (char) System.in.read();
			} // 키보드에서 입력한 값을 받아온다.
			catch (IOException e) {
				e.printStackTrace();
			} // read()에서 발생하는 IOException 처리 코드 - 아무 처리안한다. 그냥 출력만

			if (chTemp >= '0' && chTemp <= '9' && chTemp != '\r' && chTemp != '\n') // 숫자이고
																					// 엔터키(\r\n)가
																					// 아닐
																					// 경우만
				strTemp += chTemp;
		}

		try {
			return Integer.parseInt(strTemp);
		} catch (Exception e) {
			return 0;
		} // 아무값이 입력 안된 경우 예외발생

	}
}

public class ProductManagingTest {
	public static void main(String[] args) {
		Mart mart = new Mart();
		mart.martOpen(); // 시작 메소드
	}
}
