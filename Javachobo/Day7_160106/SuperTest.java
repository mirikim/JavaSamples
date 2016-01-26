package Day7_160106;

public class SuperTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}
}

class Parent {
	int x = 10; // 인스턴스 변수 (static 붙지 않은 것)
}

class Child extends Parent {
	void method() { // 인스턴스 메서드 (static 붙지 않은 것)
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x); // 물려받은 x
		System.out.println("super.x = " + super.x); // 아버지 클래스에 있는 x
	}
}