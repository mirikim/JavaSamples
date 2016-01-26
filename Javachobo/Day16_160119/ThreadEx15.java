package Day16_160119;

public class ThreadEx15 {
	public static void main(String[] args) {
		ThreadEx15_1 th1 = new ThreadEx15_1();
		ThreadEx15_2 th2 = new ThreadEx15_2();
		th1.start();
		th2.start();

		try {
			th1.sleep(5000);
			// sleep메서드는 호출된 쓰레드에 적용되는 메서드
			//=> main에서 실행되므로 실제로 sleep하는 건 main이다.
		} catch (InterruptedException e) {
		}

		System.out.println("<<main 종료>>");
	}// main
}

class ThreadEx15_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("<<th1 종료>>");
	}// run()
}

class ThreadEx15_2 extends Thread {

	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("<<th2 종료>>");
	}// run()
}