package Day9_160108;

class Point implements Cloneable {// Clonable인터페이스를 구현한 클래스에서만 clone()을 호출할 수
									// 있다.
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x=" + x + ", y=" + y;
	}

	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();//super클래스는 Object클래스를 가리킨다.즉,Object.clone()을 호출한것임
		} catch (CloneNotSupportedException e) {
			// clone메서드에는 CloneNotSupportedException이 선언되어 있으므로 이 선언되어있으므로 이 곳에서
			// 에러를 처리한다.
		}
		return (Point) obj;//복제한 obj를 Point타입으로 캐스팅해준후 리턴!
	}
}

public class CloneTest {
	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = original.clone();// 객체를 복제해서 새로운 객체를 만든다.
		System.out.println(original);
		System.out.println(copy);
	}
}
