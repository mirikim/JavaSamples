package Day8_160107;

public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();

		System.out.println("p.x = " + p.x);
		p.method();// p는 Child()인스턴스에서 정의되어있으므로 Child method호출

		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent {
int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;// 멤버변수가 중복정의 된 경우, 참조변수의 타입에 따라 연결되는 멤버변수가 달라진다.(참조변수타입에 영향받음)

	void method() {
		System.out.println("Child Method");// 오버라이딩//메서드가 중복정의된 경우. 참조변수의 타입에
											// 관계없이 항상 실제
											// 인스턴스타입에 정의된 메서드가 호출
	}

}
