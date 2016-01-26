package Day11_160112;

public class InnerEx1 {
	class InstanceInner {// 인스턴스클래스
		int iv = 100;
		// static int cv = 100;//에러! static변수를 선언할 수 없다.
		final static int CONST = 100;// static final은 상수이므로 허용한다.
	}

	static class StaticInner {// static클래스
		int iv = 200;
		static int cv = 200;// static클래스만 static멤버를 정의할 수 있다.
	}

	void myMethod() {
		class LocalInner {// myMethod()내부의 변수처럼 LocalInner클래스가 생성됨
			int iv = 300;
			// static int cv = 300;//에러! static변수를 선언할 수 없다.
			final static int CONST = 300;// staic final은 상수이므로 허용
		}
	}

	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);

	}
}
