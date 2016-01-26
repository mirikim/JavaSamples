package Day16_160119;

public class ThreadEx24 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx24();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class Account {
	int balance = 1000;

	public void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			balance -= money;
		}
	}// withdraw
}

class RunnableEx24 implements Runnable {
	Account acc = new Account();

	public void run() {
		while (acc.balance > 0) {
			// 100,200,300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int) (Math.random() * 3 + 1) * 100;
			//100 200 300의 범위
			acc.withdraw(money);
			System.out.println("balance :" + acc.balance);
			//t1 t2가 동기화가 이뤄지지않아서 - 값이 출력될 수 있음.
		}
	}//run()
	

}