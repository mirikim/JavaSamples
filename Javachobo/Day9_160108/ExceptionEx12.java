package Day9_160108;

public class ExceptionEx12 {
	public static void main(String[] args) {
		System.out.println(1);// 참조변수 ae를 통해,생성된 ArithmeticException처리
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0 / 0);// 예외발생
			System.out.println(4);// 실행되지 않는다.
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("예외 메시지 : " + ae.getMessage());
		} // try-catch의 끝
		System.out.println(6);
	}// main메서드의 끝
}
