package Day5_160104;

public class CardTest {
	public static void main(String[] args) {
		System.out.println("Card.width =" + Card.width); // static이 붙어있는 멤버변수이므로
															// 객체생성없이 바로 사용
		System.out.println("Card.height=" + Card.height);

		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;

		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;

		System.out.println("c1은" + c1.kind + "," + c1.number + "이며, 크기는(" + c1.width + "," + c1.height + ")");
		System.out.println("c2는" + c2.kind + "," + c2.number + "이며, 크기는(" + c2.width + "," + c2.height + ")");
		System.out.println("c1의 width와 height를 각각 50,80으로 변경합니다.");

		c1.width = 50;
		c1.height = 80;
		System.out.println("c1은" + c1.kind + "," + c1.number + "이며, 크기는(" + c1.width + "," + c1.height + ")");
		System.out.println("c2는" + c2.kind + "," + c2.number + "이며, 크기는(" + c2.width + "," + c2.height + ")");
	}

}

class Card {
	String kind; // 카드의 무늬 - 인스턴스 변수
	int number; // 카드의 숫자 - 인스턴스 변수
	static int width = 100;// 카드의 폭 - 클래스 변수 //static이 붙어있는 멤버변수는 객체생성하지않고도
							// 사용가능,메모리에 바로 올라간다
	static int height = 250;// 카드의 높이 - 클래스 변수

}
