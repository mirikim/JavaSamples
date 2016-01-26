package Day9_160108;

public class EqualsEx1 {
	public static void main(String[] args) {
		Value v1 = new Value(10); // Value v1는 주소값을 갖는 참조형 변수.
		Value v2 = new Value(10);

		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");// 두개의 객체 v1과 v2는 다른 주소값을 같는다.
		}
		v2 = v1;// v1이 갖는 주소값을 v2에 대입
		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
	}// main
}

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}