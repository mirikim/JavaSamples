package Day3_151230;

public class FlowEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Math클래스의 random()함수를 이용해서 1~10사이의 값을 얻을 수 있다.
		int score = (int) (Math.random() * 10) + 1; // random 함수는 0.0~1.0사이의 수를
													// 랜덤으로 double타입의값을 반환해줌

		switch (score * 100) {
		case 100:
			System.out.println("당신의 점수는 100이고,상품은 자전거입니다.");
			break;
		case 200:
			System.out.println("당신의 점수는 200이고,상품은 TV입니다.");
			break;
		case 300:
			System.out.println("당신의 점수는 300이고,상품은 노트북입니다");
			break;
		case 400:
			System.out.println("당신의 점수는 400이고,상품은 자동차입니다.");
			break;
		default:
			System.out.println("죄송하지만 당신의 점수에 해당 상품이 없습니다.");

		}
	}

}
