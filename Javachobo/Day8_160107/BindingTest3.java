package Day8_160107;

public class BindingTest3 {
	public static void main(String[] args) {
		Parent3 p = new Child3();
		Child3 c = new Child3();

		System.out.println("p.x = " + p.x);
		p.method();// p는 Child()를 가리키므로  Child의 method()로 이동
		System.out.println();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent3 {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child3 extends Parent3 {
	int x = 200;

	void method() {
		System.out.println("x = " + x);// this.x와 같다
		System.out.println("super.x = " + super.x);
		System.out.println("this.x = " + this.x);
	}
}