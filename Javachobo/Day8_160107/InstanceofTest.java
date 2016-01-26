package Day8_160107;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine3 fe = new FireEngine3();

		if (fe instanceof FireEngine3) {
			System.out.println("This is a FireEngine instance");
		}

		if (fe instanceof Car3) {
			System.out.println("This is a car instance");
		}
		if (fe instanceof Object) {
			System.out.println("This is an Object instance");
		}
	}
}// class instanceof의 연산결과가 true이면,해당타입으로 형변환이 가능하다.

class Car3 {
}

class FireEngine3 extends Car3 {
}
