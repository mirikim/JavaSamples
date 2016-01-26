package Day16_160119;

public class ThreadEx20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);// gc잠들고있음
		gc.start();

		int requiredMemory = 0;

		for (int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;
			// requiredMemory의 범위 : 0 20 40 60 80 100 120 140 160 180

			// 필요한 메모리가 사용할 수 있는 양보다 크거나
			// 전체 메모리의 60%이상을 사용했을 경우 gc를깨운다.
			if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {

				gc.interrupt();// 잠자고있는 쓰레드 t1을 깨운다.
				// InterruptedException이 발생함으로써 일시정지상태를 벗어나게 되다.=>37줄로이동

				try {
					gc.join(100);

				} catch (InterruptedException e) {

				}
			}
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
		}
	}
}

class ThreadEx20_1 extends Thread {

	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;

	public void run() {
		while (true) {
			try {
				Thread.sleep(10 * 1000);// 10초를 기다린다.
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupt().");
			}
			gc(); // garbage collection을 수행한다.
			System.out.println("Barbage Collected. Free Memory :" + freeMemory());
		}
	}

	public void gc() {
		usedMemory -= 300;
		if (usedMemory < 0)
			usedMemory = 0;
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}
