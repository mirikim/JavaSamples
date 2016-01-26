package Day3_151230;

public class OperatorEx26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;//011
		int y = 5;//101
		System.out.println("x는 " + x + "이고, y는 " + y + "일 때,");
		System.out.println("x | y =" + (x | y));//111
		System.out.println("x & y =" + (x & y));//001
		System.out.println("x ^ y =" + (x ^ y));//110

		System.out.println("true | false = " + (true | false));
		System.out.println("true & false = " + (true & false));
		System.out.println("true ^ false = " + (true ^ false));
	}

}
