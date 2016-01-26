package Day16_160119;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_1 t1 = new ThreadEx12_1("Thread1");
		ThreadEx12_2 t2 = new ThreadEx12_2("Thread2");

		t1.start();
		t2.start();
	}
}

class ThreadEx12_1 extends Thread {
	ThreadEx12_1(String name) {
		super(name);
	}

	public void run() {
		try {
			sleep(5 * 1000);// 5초동안기다린다
		} catch (InterruptedException e) {

		}
	}
}

class ThreadEx12_2 extends Thread {
	ThreadEx12_2(String name) {
		super(name);
	}

	public void run() {
		Map map = getAllStackTraces();
		//쓰레드에서 실행되는 콜스택의 모든내용을 가져와 map에저장
		Iterator it = map.keySet().iterator();
		//map에다 list형태를 갖는 key만 뽑아 Iterator객체를 생성한다.

		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread) (obj);
			//obj를 쓰레드 객체로 변환한후
			StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));
			//stacktraceelelement로 변환후 배열로 넣는다.
			System.out.println("[" + ++x + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName()
					+ ", daemon : " + t.isDaemon());
			//쓰레드의 이름과 그룹명 데몬인지아닌지를 출력
			
			for (int i = 0; i < ste.length; i++) {
				System.out.println(ste[i]);
				
			}
			System.out.println();
		}
	}
}
