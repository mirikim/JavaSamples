package Day14_160115;

import java.util.*;

public class RandomEx3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(getRand(5, 10) + ", ");
		}
		System.out.println();

		int[] result = fillRand(new int[10], new int[] { 2, 3, 7, 5 });
		System.out.println(Arrays.toString(result));

		String[] result2 = fillDistinctRand(new String[3], new String[] { "a", "b", "c", "d", "e" });
		System.out.println(Arrays.toString(result2));
	}

	public static int[] fillRand(int[] arr, int from, int to) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRand(from, to);
		}
		return arr;
	}

	public static int[] fillRand(int[] arr, int[] data) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = data[getRand(0, data.length - 1)];
		}
		return arr;
	}

	// Distinct별개의 뚜렷한
	public static String[] fillDistinctRand(String[] arr, String[] data) {
		if (arr.length <= 0 || data.length <= 0)// 잘못된 값이므로 예외처리
			return arr;

		HashSet hs = new HashSet(arr.length);
		// HashSet의 size()메서드 : Hash Set에있는 객체 개수 반환
		while (hs.size() < Math.min(arr.length, data.length)) {
			hs.add(data[getRand(0, data.length - 1)]);
		}
		Object[] tmp = hs.toArray();// HashSet의내용을 배열에넣는다.toArray()
		for (int i = 0; i < tmp.length; i++) {
			arr[i] = (String) tmp[i];
		}
		return arr;
	}

	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to - from) + 1) + Math.min(from, to));// int(Math.random()*6)
																						// +5;
		// 0~6사이의랜덤값을받고 그값에 5를 더한 값을 return
	}

}
