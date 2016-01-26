package Day9_160108;

public class ExceptionEx6 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음.");
			throw e;// 예외를 발생시킴
			// throw new Exception("고의로 발생시켰음.");//위의 두줄을 한줄로 줄여 쓸 수 있다.

		} catch (Exception e) {
			System.out.println("에러메시지 : " + e.getMessage());
			e.printStackTrace();//어디에서 에러가 났는지 추적해서 print해줌
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}
}
