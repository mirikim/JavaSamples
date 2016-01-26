package Day9_160108;

public class ExceptionEx11 {
	public static void main(String[] args) {// 0으로 나눠서 ArithmeticExcetpion처리

		System.out.println(1);
		System.out.println(2);

		try {
			System.out.println(3);
			System.out.println(0 / 0);
			System.out.println(4);// 실행이 되지 않는다.
		} catch (ArithmeticException ae) {
			if (ae instanceof ArithmeticException) {
				System.out.println("true");
				System.out.println("ArithmeticException");
			}

		} catch (Exception e) {// ArithmeticException을 제외한 모든 에러처리
		
			System.out.println("Exception");
		} // try-catch의 끝
		System.out.println(6);

	}// main메서드의 끝
}
