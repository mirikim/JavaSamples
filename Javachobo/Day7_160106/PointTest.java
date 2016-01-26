package Day7_160106;

public class PointTest {
	public static void main(String[] args) {
		Point3D1 p3 = new Point3D1(1, 2, 3);
	}
}

class Point1 {
	int x;
	int y;

	// Point3D1에 super 메소드를 자동적으로 첫줄에 삽입하여 수행하기 때문에
	// 빈 생성자를 추가해줘야함!!
	// 왜냐하면 다른 생성자가 있기 때문에 default 생성자가 자동으로 생성이안되요
	// Point1() { }

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}

class Point3D1 extends Point1 {
	int z;

	Point3D1(int x, int y, int z) {

		super(x, y);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	String getLocation() { // 오버라이딩
		return "x : " + x + ", y : " + y + ", z = " + z;
	}
}