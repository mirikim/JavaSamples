package Day16_160119;

public class ThreadEx5 {
	static long startTime = 0;

	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("소요시간1: " + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}//ThreadEx4보다 시간이 더걸림 = >
//프로세스 우선순위

class ThreadEx5_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println();
		System.out.println("소요시간2: " + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}
