package Day2_151229;

public class CastingEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 10;
		int i = (int) b;
		System.out.println("i=" + i);
		System.out.println("b=" + b);

		int i2 = 300; // 300은 이진수 1 0010 1100(2)
		byte b2 = (byte) i2; //형변환을 통해 이진수 1100(2) 가된다.
		System.out.println("i2=" + i2);
		System.out.println("b2=" + b2);
	}

}
