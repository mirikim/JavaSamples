package Day6_160105;

class Data1_1 {
	int value;
}

class Data2_1 {
	int value;

	Data2_1(int x) { // 매개변수가 있는 생성자.
		value = x;
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		Data1_1 d1 = new Data1_1();
		// Data2_1 d2 = new Data2_1(); // compile error발생
	}
}
