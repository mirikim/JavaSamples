package Day11_160112;

import java.awt.List;
import java.util.ArrayList;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;// 자르고자 하는 글자의 개수를 지정한다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();// 43

		ArrayList list = new ArrayList(length / LIMIT + 10);// 크기를 약간 여유 있게 잡는다.
															// new
															// ArryaList(14);

		for (int i = 0; i < length; i += LIMIT) {
			if (i + LIMIT < length)
				list.add(source.substring(i, i + LIMIT));// 하나의 오브젝트단위로(i부터
															// i+LIMIT까지 list의
															// element에 저장
			else
				list.add(source.substring(i));// i(=40)부터 끝까지 list에 저장
		}

		for (int i = 0; i < list.size(); i++) {// list.size() : list에 저장된 객체의
												// 갯수를 반환하는메소드 =>5개
			System.out.println(list.get(i));
		}
	}// main
}
