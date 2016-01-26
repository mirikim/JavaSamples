package Day6_160105;

class Product {
	static int count = 0;// 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo;// 인스턴스 고유의 번호

	{
		++count;// static변수가 아닐경우인스턴스를 아무리 실행해도 초기값 0을 계속갖게되어 1만출력
		serialNo = count;
	} // 인스턴스 변수 초기화 블록 - 인스턴스가 생성될 때 마다 실행됨

	public Product() {
	}
}

public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();

		System.out.println("p1의 제품번호(serial no)는 " + p1.serialNo);
		System.out.println("p2의 제품번호(serial no)는 " + p2.serialNo);
		System.out.println("p3의 제품번호(serial no)는 " + p3.serialNo);
		System.out.println("생산된 제품의 수는 모두 " + Product.count + "개 입니다.");
	}
}
