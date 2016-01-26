package Day8_160107;

public class CastingTest2 {
	public static void main(String args[]) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;

		car.drive();

		fe = (FireEngine) car;// 여기서 사용된 car는 위에서 생성된 Car car 이므로
								// 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수 는 없다.
		fe.drive();

		car2 = fe;
		car2.drive();
	}
}
