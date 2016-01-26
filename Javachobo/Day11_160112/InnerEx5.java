package Day11_160112;

class Outer2 {
	int value = 10;// Outer.this.value//인스턴스변

	class Inner {// 인스턴스클래스
		int value = 20;// this.value

		void method1() {
			int value = 30;
			System.out.println("           value | " + value);
			System.out.println("      this.value | " + this.value);
			System.out.println("Outer.this.value | " + Outer2.this.value);
		}
	}// Inner class 의
}// outer클래스의

public class InnerEx5 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner inner = outer.new Inner();
		inner.method1();
	}
}// InnerEx5의끝
