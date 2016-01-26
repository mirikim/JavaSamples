package Day3_151230;

public class FlowEx26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 10; i++) {
			if (i % 3 == 0)
				continue;// 조건식이 true가되어 continue문이 수행되면 반복문의 끝으로 이동한다. break문과
							// 달리 반복문전체를 벗어나지않는다. ,반복문 내에서만 쓰인다
			System.out.println(i);
		}
	}

}
