package Day16_160119;

import java.util.*;

class ThreadTest {
	static Vector words = new Vector();
	static String[] data = { "강동원", "유아인", "박보검", "이동휘", "TOP", "원빈", "류준열", "박해진", "서강준", "조정석", "김수현", "지드레곤", "조인성",
			"공유" };
	int interval = 2 * 1000; // 2초

	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) throws InterruptedException {

		ThreadTest game = new ThreadTest();

		game.wg.start();

		Vector words = game.words;
		System.out.println("============= GAME START =============");
		System.out.println("* 게임종료는 'q','Q' 를 입력해주세요 *");
		System.out.println("* 단어가 15개 이상나타나면 GAME OVER *");
		System.out.println("======================================");
		Thread.sleep(100);// 빈배열을 출력하지 않기 위해서 run()이 실행할 수있는 시간을 준다.
		while (true) {
			System.out.println(words);

			String prompt = ">>";
			System.out.print(prompt);

			// 화면으로부터 라인단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();

			int index = words.indexOf(input);//배열에서 제거하기위해 index부여

			if (index != -1) {
				words.remove(index);
			}
			if (input.equalsIgnoreCase("q")) {//프로그램종료

				System.out.println("=============  GAME END  =============");
				System.out.println("*     이용해 주셔서 감사합니다.      *");
				System.out.println("======================================");
				System.exit(0);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			/*
			 * (1) 알맞은 코드를 넣으시오. 1. interval(2초)마다 배열 data의 값 중 하나를 임의로 선택해서 2.
			 * words에 저장한다.
			 */
			while (true) {
				try {
					int dataNum = (int) (Math.random() * data.length);
					String dataString = data[dataNum];
					words.add(dataString);

					sleep(2000);
				} catch (Exception e) {
				}

				if (words.size() >= 15) {
					System.out.println();
					System.out.println(words);
					System.out.println("============= GAME  OVER =============");
					System.exit(0);
				}

			} // end of while

		} // end of run()
	} // class WordGenerator
} // ThreadTest
