package Day3_151230;

public class OperatorEx22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp; // 계산 결과를 담기 위한 변수

		System.out.println(-8);
		// -8을 2진수 문자열로 변경한다.
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();
		temp = -8 << 1;
		System.out.println("-8 << 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

		temp = -8 << 2;
		System.out.println("-8 << 2 =" + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

		System.out.println();
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();

		temp = -8 >> 1;
		System.out.println("-8 >> 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

		temp = -8 >> 2;
		System.out.println("-8 >> 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

		System.out.println();
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();

		temp = -8 >>> 1;//음수건 양수전 최상위 비트 0셋팅
		System.out.println("-8 >>> 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

		temp = -8 >>> 2;
		System.out.println("-8 >>> 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();

	}

}
