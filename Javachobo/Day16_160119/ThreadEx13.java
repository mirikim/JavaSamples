package Day16_160119;

public class ThreadEx13 {
	static long startTime = 0;

	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		ThreadEx13_2 th2 = new ThreadEx13_2();

		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();

		try {
			th1.join();// th1의작업이 끝날 때 까지 기다린다.
			th2.join();// th2의작업이 끝날 때 까지 기다린다.
		} catch (InterruptedException e) {
		}
		System.out.println();
		System.out.print("소요시간 : " + (System.currentTimeMillis() - ThreadEx13.startTime));
	}// main
}

class ThreadEx13_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}// run()
}

class ThreadEx13_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}// run()
}
