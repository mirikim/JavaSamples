package Day7_160106;

import java.awt.Frame;
import java.awt.Graphics;

public class DrawShape extends Frame {
	public static void main(String[] args) {// main 메서드
		DrawShape win = new DrawShape("도형그리기");
	}

	// Frame을 상속받아서 paint가 실행됨
	@Override
	public void paint(Graphics g) {// paint메서드
		Point[] p = { new Point(100, 100), new Point(140, 50), new Point(200, 100) };
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150, 150), 50);

		// 원을 그린다.
		g.drawOval(c.center.x, c.center.y, c.r, c.r);// c.center.x : c라는
														// Cricle객체에있는
														// center라는point객체의
														// 객체변수x

		// 직선 3개로 삼각형을 그린다.
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x, t.p[1].y);// 객체명g.메소드명drawLine();
		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x, t.p[2].y);
		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x, t.p[0].y);

	}

	public DrawShape(String title) {// 생성자
		super(title);// super는 상위클래스에있는 생성자 메소드를 호출할때 사용한다.
		setSize(500, 500);
		setVisible(true);

	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {// default생성자- 기본값
		this(0, 0);
	}

}

class Triangle {
	Point[] p = new Point[3];// point와 Triangle은 포함관계(has a)

	Triangle(Point[] p) {
		this.p = p;
	}

	Triangle(Point p1, Point p2, Point p3) {
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
	}
}

class Circle {
	Point center;// 원의 원점좌표//point와 circle은 포함관계(has a)
	int r;// 반지름

	Circle() {// default생성자 기본값
		this(new Point(0, 0), 100);

	}

	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
}
