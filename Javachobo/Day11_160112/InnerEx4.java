package Day11_160112;

class Outer {
	class InstanceInner {
		int iv = 100;

	}

	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}

	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}

	void myMethod2() {// Local은myMethod()내부에서만 통용된다.
		class LocalInner {
			int iv = 400;
		}
	}
}

public class InnerEx4 {
	public static void main(String[] args) {
		// 인스턴스 클래스의 인스턴스를 생성하려면 외부크래스의 인스턴스를 먼저 생성해야 한다.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

		// static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv : " + si.iv);
	}
}
