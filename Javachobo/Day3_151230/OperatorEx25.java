package Day3_151230;

public class OperatorEx25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char x = 'j';
		if ((x >= 'a' && x <= 'z') || (x > 'A' && x <= 'Z')) {
			System.out.println("유효한 문자입니다.");
		} else {
			System.out.println("유효하지 않은 문자입니다.");
		}

		char x2 = 1213;
		if ((x2 >= 0 && x2 <= 99) || (x2 >= 1000 && x2 <= 9999)) {
			System.out.println("유효한 숫자입니다.");
		} else {
			System.out.println("유효하지 않은 숫자입니다.");
		}

	}

}
