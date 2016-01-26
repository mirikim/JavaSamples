package Day18_160121;

import java.awt.*;
import java.awt.event.*;

class PaintFrameTest {
	public static void main(String[] args) {
		PaintFrame f = new PaintFrame("PaintFrame");

		Graphics g = f.getGraphics();// 그리기위해필요한객체 getGraphicse()
		g.setColor(Color.red);

		for (int i = 0; true; i += f.speed) {
			try {
				Thread.sleep(100);// 0.1초 동안 실행을지연시킨다.
			} catch (InterruptedException e) {
			}

			g.clearRect(0, 0, 300, 300);// 글자가이동할때 배경을 지운다.
			g.drawString("Hello", i, 150);

			i = (i < 300) ? i : 0; // i가 300을 넘으면다시 0부터 시작
		}
	}// main메서드의 끝
}

class PaintFrame extends Frame {
	int speed = 1;
	Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 5, 0, 50);
	Label lSpeed = new Label("Speed : 1");// Label값초기설정

	PaintFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		lSpeed.setBackground(Color.yellow);
		lSpeed.setSize(65, 15);
		lSpeed.setLocation(10, 30);

		sb.setSize(260, 20);
		sb.setLocation(20, 250);
		add(sb);
		add(lSpeed);
		sb.addAdjustmentListener(new MyHandler1());
		addWindowListener(new MyHandler1());
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
		setResizable(false);// Frame의 크기를 변경할 수 없도록한다.

	}

	class MyHandler1 extends WindowAdapter implements AdjustmentListener {
		// 스크롤바를 썻기때문에 AdjustmentListener 인터페이스를 구현한다.
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			speed = sb.getValue();// Scrollbar의 현재값을 얻는다
			lSpeed.setText("Speed : " + speed);// 속도에따라 Label값 변경
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);// 종료버튼 누르면 시스템 종료
		}
	}
}// class PaintFrame
