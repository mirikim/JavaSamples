package Day7_160106;

//호출 순서 알아보는 예제
public class PointTest2 {
	public static void main(String[] args) {
		Point3D2 p3 = new Point3D2();
		System.out.println("p3.x = " + p3.x);
		System.out.println("p3.y = " + p3.y);
		System.out.println("p3.z = " + p3.z);
	}
}

class Point2 {
	int x = 10;
	int y = 20;

	Point2(int x, int y) {
		//super(); - Object 상속 - 여기가 최종목적지
		this.x = x;
		this.y = y;
	}
}

class Point3D2 extends Point2 {
	int z = 30;

	Point3D2() {
		this(100, 200, 300); // Point3D2(int x, int y, int z) 생성자 를 호출한다
	}

	Point3D2(int x, int y, int z) {
		super(x, y); // Point2(int x, int y)를 호출한다
		//그이유 : 하위클래스에서 받아서 사용하려면 초기화를 해야되기 때문에.
		this.z = z;
	}
}