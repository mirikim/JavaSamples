package Day3_151230;

public class FlowEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 'A','B','C','D' 중의 하나를 얻을 수 있다.
		char ch = (char) (Math.random() * 4 + 'A'); // *4는 얻어내고자 하는 수의 개수가 4개
		int score = 0;
		switch (ch) {
		case 'A':
			score = 90;
			break;
		case 'B':
			score = 80;
			break;
		case 'C':
			score = 70;
			break;
		case 'D':
			score = 60;
			break;

		}
		System.out.println("당신의 점수는" + score + "점 이상 입니다.");
		/////////////////////////////////////////////////
		char ch2 = (char) (Math.random() * 26 + 'A');
		System.out.println("당신의 알파벳은" + ch2 + "입니다.");
		System.out.println("당신의 점수는" + (int) ch2 + "입니다.");
	}

}
