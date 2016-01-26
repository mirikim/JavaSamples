package Day9_160108;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int number = 1000;
		int result = 0;

		for (int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 10);// java.lang.ArithmeticException : 랜덤수가 0이 될경우 나누기 에러가 발생함 
			System.out.println(result);
		}
	}
}
