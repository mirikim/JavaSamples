package Day16_160119;

public class ThreadEx14 {
	public static void main(String[] args) {
		ThreadEx14_1 th1 = new ThreadEx14_1();
		ThreadEx14_2 th2 = new ThreadEx14_2();

		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
		}
		th2.start();
		//th1dl 종료될때 까지 기달린 후에 th2를 시작한다.
	}
}

class ThreadEx14_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx14_2 extends Thread {
	@Override
	public void run() {
	for(int i=0;i<300;i++){
		System.out.print("|");
	}
	}
}