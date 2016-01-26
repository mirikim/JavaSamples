package Day8_160107;

public class InterfaceTest3 {
	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA();// 제 3의 클래스의 메서드를 통해서 인터페이스 I를 구현한다.
	}
}

class A3 {
	void methodA() {
		I3 i = InstanceManager.getInstance();
		System.out.println("2");
		i.methodB();
	}
}

interface I3 {
	public abstract void methodB();

}

class B3 implements I3 {
	public void methodB() {
		System.out.println("methodB in B class");
	}
}

class InstanceManager {
	public static I3 getInstance() {
		System.out.println("1");
		return new B3();
	}
}
