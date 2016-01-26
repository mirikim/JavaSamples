package Day6_160105;

class Car3 {
	String color;// 색상
	String gearType;// 변속기 종류 -auto/manual
	int door;

	Car3() {
		this("white", "auto", 4);
	}

	Car3(Car3 c) { // 인스턴스의 복사를 위한 생성자.
		// this(c.color,c.gearType,c.door);
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}

	Car3(String color, String gearType, int door) {
		this.color = color;// this는 객체자신Car2(String color, String gearType, int
							// door)을 나타낸다.
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest3 {
	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3(c1);// c1의 복사본 c2를 생성

		System.out.println("c1의 color = " + c1.color + " , gearType = " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + " , gearType = " + c2.gearType + ", door = " + c2.door);

		c1.door = 100; // c1의 인스턴스변수 door의 값을 변경한다.
		System.out.println("c1.door = 100; 수행 후");

		System.out.println("c1의 color = " + c1.color + " , gearType = " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + " , gearType = " + c2.gearType + ", door = " + c2.door);

	}
}
