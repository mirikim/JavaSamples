package Day12_160113;

import java.util.Arrays;

public class CopyTest {
	public static void main(String[] args) {
		int[] data = { 0, 1, 2, 3, 4 };
		int[] sCopy = null;
		int[] dCopy = null;

		sCopy = shallowCopy(data);//shallowCopy메소드를 호출해서 sCopy에 저장
		dCopy = deepCopy(data);//deepCopy메소드를 호출해서 dCopy에 저장

		System.out.println("Original : " + Arrays.toString(data));
		System.out.println("Shallow  : " + Arrays.toString(sCopy));
		System.out.println("Deep     : " + Arrays.toString(dCopy));
		System.out.println();

		data[0] = 5;
		System.out.println("Original : " + Arrays.toString(data));
		System.out.println("Shallow  : " + Arrays.toString(sCopy));
		System.out.println("Deep     : " + Arrays.toString(dCopy));

	}

	public static int[] shallowCopy(int[] arr) {
		return arr;
	}

	public static int[] deepCopy(int[] arr) {
		if (arr == null)
			return null;
		int[] result = new int[arr.length];// arr의 크기만큼 새로운 배열 result를 생성

		System.arraycopy(arr, 0, result, 0, arr.length);// arr의 인덱스 0의위치부터 끝까지
														// result의 인덱스0에 값을 복사
		return result;
	}
}
