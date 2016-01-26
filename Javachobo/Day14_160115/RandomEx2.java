package Day14_160115;

import java.util.*;

public class RandomEx2 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];

		for (int i = 0; i < number.length; i++) {
			// System.out.print(number[i] = (int) (Math.random() * 10));
			// 0<=x<10범위의 정수 x를 반환한다.

			System.out.print(number[i] = rand.nextInt(10));
			// int형의 범위 전체에서 난수를 발생하여 반환한다.
			// 0~10사이의 정수를 리턴(10은포함이안됨)
		}
		System.out.println();
		for (int i = 0; i < number.length; i++) {
			counter[number[i]]++;
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.println(i + "의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
		}
	}

	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
