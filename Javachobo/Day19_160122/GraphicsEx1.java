package Day19_160122;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx1 extends Frame {
	public static void main(String[] args) {
		new GraphicsEx1("GraphicsEx1");
	}

	// Paint메서드는 Grapics개체를 그리고자할때 자동호출되는 메서드이다.
	// 화면이 가려졌다 다시보일때마다 다시 그린다.
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics를 이용해서 그림을 그립니다.", 10, 50);

		g.drawOval(50, 100, 50, 50);
		g.setColor(Color.blue);
		g.fillOval(100, 100, 50, 50);

		g.setColor(Color.red);
		g.drawLine(100, 100, 150, 150);

		g.fillRoundRect(200, 100, 120, 80, 30, 30);
		g.setColor(Color.orange);
		g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250, }, 4);
		// 다각형그리기
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120);
		// 호그리기
	}

	public GraphicsEx1(String title) {
		super(title);
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		// Frame을(100,100)의 위치에 width 400,height 300크기로 보이게 한다.
		setBounds(100, 100, 400, 300);
		setVisible(true);
	}
}// class
