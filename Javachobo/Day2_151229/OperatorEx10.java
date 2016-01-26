package Day2_151229;

public class OperatorEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1000000;
		int b = 2000000;
		// long c = a * b; //overflow발생으로 2,000,000,000,000 값이 안나옴
		long c = (long) a * b;
		System.out.println(c);
	}

}
