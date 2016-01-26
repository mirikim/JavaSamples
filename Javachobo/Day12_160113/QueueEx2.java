package Day12_160113;

import java.util.*;

public class QueueEx2 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;// Queue에 최대 5개까지만 저장되도록한다.

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		while (true) {
			System.out.println(">>");
			try {
				// 화면으로부터 라인단위로 입력받는다.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();

				if ("".equals(input))// input값이 빈문자열이면
					continue;// 자신이 포함된 반복문의 끝으로 이동한다.->12라인으로 이동
				if (input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help . 도움말을 보여 줍니다.");
					System.out.println(" q또는 Q . 프로그램을 종료합니다.");
					System.out.println(" history . 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");

				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					// 입력받은 명령어를 저장하고,
					save(input);

					// LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();// ListIterator()는
															// list에계속 접근할
															// 수있는메소드로
					// ListIterator메서드를 이용해서 배열의 값을 확인한다.
					while (it.hasNext()) {// hasNext()는 읽어 올 요속 남아있는지 확인한다. 있으면
											// true, 없으면 false
						System.out.println(++i + "." + it.next());// next()
																	// 다음요소를
																	// 읽어온다
																	// next()를
																	// 호출하기전
																	// hasNext()를
																	// 이용해 요소가
																	// 있는지 확인.
					}

				} else {
					save(input);
					System.out.println(input);
				} // if(input.equalsIgnoreCase("q")){
			} catch (Exception e) {
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	}// main()

	public static void save(String input) {
		// queue에 저장한다.
		if (!"".equals(input)) {
			q.offer(input);
		}
		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if (((LinkedList) q).size() > MAX_SIZE) {
			q.remove();// remove()는 맨앞에있는 요소를 삭제한다.
		}
	}
}// end of class
