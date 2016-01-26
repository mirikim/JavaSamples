package Day16_160119;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);// 생성자 Thread(Runnable target)
		// 한번사용한 쓰레드는 재사용 할 수 없다. => start()를 한번밖에못한다.
		// java.lang.IllegalThreadStateException
		t1.start();// 쓰레드메소드를 실행시키는
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {//
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());// 조상인 Thread의 getName()을 호출
			// getName() 클래스 이름을 리턴!
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			// THread.currentThread() -현재 실행중인 Thread를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}
}
