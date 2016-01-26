package Day12_160113;

import java.util.*;

import Day11_160112.MyVector;

//MyVector클래스를 상속받으므로 같은 패키지 내에 있어야한다.
public class MyVector2 extends MyVector implements Iterator {
	int cursor = 0;// 현재 커서위치를 0으로 기준한다면
	int lastRet = -1;// lastRet은 이전의 값이므로 0보다 하나작은 -1이어햔다.

	public MyVector2(int capacity) {// 생성자메서드
		super(capacity);
	}

	public MyVector2() {// 생성자메서드
		this(10);
	}

	public String toString() {// Object클래스에 있는 메서드 toString()
		String tmp = "";
		Iterator it = iterator();
		for (int i = 0; it.hasNext(); i++) {
			if (i != 0)
				tmp += ", ";
			tmp += it.next();// tmp += next().toString();
		}
		return "[" + tmp + "]";

	}

	public Iterator iterator() {// Iterator 객체 생성 메서드
		cursor = 0;// cursor와 lastRet을 초기화 한다.
		lastRet = -1;
		return this;
	}

	public boolean hasNext() {
		return cursor != size();
	}

	public Object next() {
		Object next = get(cursor);// cursor는 앞으로 읽어올 위치를 저장하는 요소
		lastRet = cursor++;
		return next;
	}

	public void remove() {// remove메서드는 next()로 읽어 온 요소를 샂게한다. next()를 호출한 다음에
							// remove()를 호출해야한다.(선택적기능)
		// 더이상 삭제할 것이 없으면 IllegalStateException를 발생
		if (lastRet == -1) {
			throw new IllegalStateException();
			//에러가 왜 생겼는지 알기 위해서 예외처리를 한다.
		} else {
			remove(lastRet);// lastRet은 바로 직전에 읽어온 위치
			// 현재 위치(cursor)보다 이전의 것을 삭제했다면, cursor의 위치를 하나 감소시킨다.
			if (lastRet < cursor)
				cursor--;
			lastRet = -1;// lastRet의 값을 초기화 한다.
		}
	}

	
}// class