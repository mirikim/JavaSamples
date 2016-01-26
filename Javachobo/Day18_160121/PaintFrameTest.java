package Day18_160121;

import java.awt.*;
import java.awt.event.*;

class PaintFrameTest {
	public static void main(String[] args) {
		PaintFrame f = new PaintFrame("PaintFrame");

		Graphics g = f.getGraphics();// �׸��������ʿ��Ѱ�ü getGraphicse()
		g.setColor(Color.red);

		for (int i = 0; true; i += f.speed) {
			try {
				Thread.sleep(100);// 0.1�� ���� ������������Ų��.
			} catch (InterruptedException e) {
			}

			g.clearRect(0, 0, 300, 300);// ���ڰ��̵��Ҷ� ����� �����.
			g.drawString("Hello", i, 150);

			i = (i < 300) ? i : 0; // i�� 300�� ������ٽ� 0���� ����
		}
	}// main�޼����� ��
}

class PaintFrame extends Frame {
	int speed = 1;
	Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 5, 0, 50);
	Label lSpeed = new Label("Speed : 1");// Label���ʱ⼳��

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
		setResizable(false);// Frame�� ũ�⸦ ������ �� �������Ѵ�.

	}

	class MyHandler1 extends WindowAdapter implements AdjustmentListener {
		// ��ũ�ѹٸ� ���⶧���� AdjustmentListener �������̽��� �����Ѵ�.
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			speed = sb.getValue();// Scrollbar�� ���簪�� ��´�
			lSpeed.setText("Speed : " + speed);// �ӵ������� Label�� ����
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);// �����ư ������ �ý��� ����
		}
	}
}// class PaintFrame
