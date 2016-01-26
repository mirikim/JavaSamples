package Day11_160112;

import Day11_160112.Outer_1.Inner;
import Day11_160112.Outer_2.Inner2;
import Day11_160112.Outer_3.Inner3;

class Outer_1 {
	class Inner {
		int iv = 100;
	}
}

class Outer_2 {
	static class Inner2 {
		int iv2 = 200;
	}
}

class Outer_3 {
	int value = 10;

	class Inner3 {
		int value = 20;

		void method1() {
			int value = 30;

			System.out.println("(3-1)              value : " + value);
			System.out.println("(3-2)         this.value : " + this.value);
			System.out.println("(3-3) Outer_3.this.value : " + Outer_3.this.value);
		}
	}// Inner3클래스의 끝
}// Outer_3클래스의끝

public class Excercise11 {
	public static void main(String[] args) {
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오. iv 값출력
		 */
		Outer_1 ot = new Outer_1();
		Inner in = ot.new Inner();
		System.out.println("(1) iv : " + in.iv);
		// => System.out.println("(1) iv : " + ot.new Inner().iv);

		/*
		 * (2) 알맞은 코드를 넣어 완성하시오. static class Inner2의 iv2 값출력
		 */
		Outer_2.Inner2 in2 = new Outer_2.Inner2();
		System.out.println("(2) iv2 : " + in2.iv2);
		// =>System.out.println("(2) iv2 : " + new Outer_2.Inner2().iv2);

		/*
		 * (3-4) 알맞은 코드를 넣어 완성하시오.
		 */
		Outer_3 ot3 = new Outer_3();
		Inner3 inner3 = ot3.new Inner3();
		inner3.method1();

	}
}
