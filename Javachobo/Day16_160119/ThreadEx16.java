package Day16_160119;

public class ThreadEx16 {
	public static void main(String[] args) {
		RunImpleEx16 r = new RunImpleEx16();
		Thread th1 = new Thread(r, "*");
		Thread th2 = new Thread(r, "**");
		Thread th3 = new Thread(r, "***");

		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000);
			// sleep메서드는 호출된 쓰레드에 적용되는 메서드
			//=> main에서 실행되므로 실제로 sleep하는 건 main이다.
			
			
			th1.suspend();// 쓰레드 th1을 잠시중단시킨다.
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();// 쓰레드 th1이 다시 동작하도록 한다.
			Thread.sleep(3000);
			th1.stop();// 쓰레드 th1을 강제종료시킨다.
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {
		}
	}// main
}

class RunImpleEx16 implements Runnable {
	@Override
	public void run() {
		while (true) {
			//현재실행중인 쓰레드의 이름을 출력
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}// run
}
