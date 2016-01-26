package Day2_151229;

public class OperatorEx14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'a';

		// char c2 = c1+1; //라인 5: 컴파일 에러발생(묵시적으로 c1+1이 int로 casting되기때문)
		char c2 = 'a' + 1; // 라인 6 : 컴파일 에러 없음

		System.out.println(c2);
	}

}
