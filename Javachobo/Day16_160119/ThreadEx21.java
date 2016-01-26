package Day16_160119;

public class ThreadEx21 {
	public static void main(String[] args) {
		RunnableImpl r = new RunnableImpl();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		//쓰레드 총3개 main/t1/t2
		t1.start();
		t2.start();

	}
}

class RunnableImpl implements Runnable {
	int iv = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int lv = 0;
		String name = Thread.currentThread().getName();

		while (lv < 3) {
			System.out.println(name + " Local Var : " + ++lv);
			System.out.println(name + " Instance Var :" + ++iv);
			//System.out.println(name + " Instance Var :" + ++(this).iv);
			System.out.println();
		}
	}// run
}
