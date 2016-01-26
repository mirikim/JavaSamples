package Day15_160118;

import java.util.*;

class Product {
}

class Tv extends Product {
}

class Audio extends Product {
}

public class GenericsEx1 {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList();

		productList.add(new Tv());
		productList.add(new Audio());

		tvList.add(new Tv());
		tvList.add(new Tv());

		printAll(productList);
		// printAll(tvList);//컴파일에러가발생

		printAll2(productList);// ArrayList<Product>
		printAll2(tvList);// ArrayList<Tv>

	}

	public static void printAll(ArrayList<Product> list) {
		// public static void printAll(ArrayList<? extends Product> list) {
		// Product클래스를 상속받는 모든 클래스 객체타입을 입력값으로받을수있다.
		for (Product p : list) {
			System.out.println(p);
		}
	}

	// public static void printAll2(ArrayList<? extends Product>list){
	public static <T extends Product> void printAll2(ArrayList<T> list) {
		// pirntAll2의 리턴타입의 값을 <T extends Product>로
		// <T extends Product>는 일반화된 객체 T가 Product클래스를 상속한다
		// =>즉 Product클래스를 상속받는 모든 클래스 타입 T의 형태로 리턴한
		for (Product p : list) {
			System.out.println(p);
		}
	}

}
