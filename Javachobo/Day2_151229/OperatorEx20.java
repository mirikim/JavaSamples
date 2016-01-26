package Day2_151229;

public class OperatorEx20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// i가 1부터 10이 될 때까지,{}안의 문장을 반복 수행한다.
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) { // i가 3으로 나누어 떨어지면 ,3의 배수출력
				System.out.println(i);
			}
		}
	}

}
