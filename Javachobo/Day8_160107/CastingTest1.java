package Day8_160107;

public class CastingTest1 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;// car =(Car)fe;에서 형변환이 생략된 형태다.
		// car.water();//컴파일 에러!! Car타입의 참조변수로는 water()를 호출할수없다.
		fe2 = (FireEngine) car;// 자손타입 <-조상타입
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() {
		// 운전하는 기능
		System.out.println("drive, Brrr~");
	}

	void stop() {
		// 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car {// 소방차

	void water() {
		System.out.println("water!!!");
	}
}
