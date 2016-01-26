package Day6_160105;

public class MainTest {
	public static void main(String[] args) {
		main(null); // 자기 자신을 다시 호출한다.
		// stackoverflowError발생 -> main->main->main->....를 계속 호출함에 인해 스택이 꽉차
		// 버리므로 에러발생
	}
}
