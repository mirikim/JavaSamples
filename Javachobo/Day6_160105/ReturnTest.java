package Day6_160105;

public class ReturnTest {
	public static void main(String[] args) {
		ReturnTest r = new ReturnTest();

		int result = r.add(3, 5);
		System.out.println(result);

		int[] result2 = { 0 };
		r.add(3, 5, result2);
		System.out.println(result2[0]);
	}

	int add(int a, int b) {
		return a + b;
	}// return이용

	void add(int a, int b, int[] result) {
		result[0] = a + b;
	}// 반환값없이 result[0]으로 , int[]result는 참조형 매개변수라고한다. (배열은 참조형변수기때문)
}