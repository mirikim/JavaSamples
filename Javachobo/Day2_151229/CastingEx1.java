package Day2_151229;

public class CastingEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 100.0;
		int i = 100;
		int result = i + (int) d;

		System.out.println("d=" + d);
		System.out.println("i=" + i);
		System.out.println("result=" + result);

		////////////////////////////////////////
		double result2 = i + d;
		System.out.println("result2=" + result2);
	}

}
