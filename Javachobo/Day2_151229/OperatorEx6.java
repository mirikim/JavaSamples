package Day2_151229;

public class OperatorEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 10;
		// byte result = ~b; //error
		byte result = (byte) ~b;

		System.out.println("b = " + b);
		System.out.println("~b = " + result);
	}

}
