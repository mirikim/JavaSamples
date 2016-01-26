package Day4_151231;

public class ArrayEx6_1 {

	public static void main(String[] args) {

		int[] number = { 100, 20, 30, 40, 90, 50, 55, 85 };
		int[] counter = new int[101];

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < number.length; i++) {
			counter[number[i]]++;
		}
		for (int i = 0; i < counter.length; i += 5) {
			System.out.println(i + "점의개수" + counter[i]);
		}
	}
}
