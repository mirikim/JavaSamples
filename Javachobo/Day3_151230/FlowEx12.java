package Day3_151230;

public class FlowEx12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0; // 합계를 저장하기 위한 변수

		for (int i = 1; i <= 10; i++) {
			sum += i;// sum = sum + i;
			System.out.println(i - 1 + "까지의 합: " + sum);
		}
		// System.out.println(i - 1 + "까지의 합: " + sum);//에러발생
	}

}
