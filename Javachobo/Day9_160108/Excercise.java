package Day9_160108;

class Exercise {
	public static void main(String[] args) {
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		int count = 0;

		// 화면으로 부터 사용자 입력을 받기 위해서 Scanner클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);

		do {

			count++;
			System.out.print("1과 100사이의 값을 입력하세요 :");
			input = s.nextInt();

			if (answer > input) {
				System.out.println("큰 수.");
			} else if (answer < input) {
				System.out.println("작은 수");
			} else {
				System.out.println("OK!~");
				System.out.println("시도횟수는 " + count + "번입니다.");
				break;
			}
		} while (true);
	}
}