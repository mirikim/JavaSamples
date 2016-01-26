package Day6_160105;

public class BlockTest {
	static {
		System.out.println("static{ }");
	} // 클래스 초기화 블럭 - 클래스가 로딩될떄 한번 실행

	{
		System.out.println("{ }");
	} // 인스턴스 초기화 블럭 - 인스턴스가 생성될때 마다 실행

	public BlockTest() {
		System.out.println("생성자");
	}// 생성자 메서드

	public static void main(String[] args) {
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();

		System.out.println("BlockTest bt2 = new BlockTest();");
		BlockTest bt2 = new BlockTest();
	}
}
