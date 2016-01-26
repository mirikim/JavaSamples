package Day6_160105;

class Car2 {
	String color;// 색상
	String gearType;// 변속기 종류 -auto/manual
	int door;

	Car2() {
		this("white", "auto", 4);
	}

	Car2(String color) {
		this(color, "auto", 4);//this 는 생성자 메서드중 하나.
	}

	Car2(String color, String gearType, int door) {
		this.color = color;//this는 객체자신Car2(String color, String gearType, int door)을 나타낸다.
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest2 {
	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue");

		System.out.println("c1의 color = " + c1.color + " , gearType = " + c1.gearType + ", door = " + c1.door);
		System.out.println("c2의 color = " + c2.color + " , gearType = " + c2.gearType + ", door = " + c2.door);
	}
}
