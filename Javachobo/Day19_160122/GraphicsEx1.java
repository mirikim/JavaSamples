package Day19_160122;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx1 extends Frame {
	public static void main(String[] args) {
		new GraphicsEx1("GraphicsEx1");
	}

	// Paint�޼���� Grapics��ü�� �׸������Ҷ� �ڵ�ȣ��Ǵ� �޼����̴�.
	// ȭ���� �������� �ٽú��϶����� �ٽ� �׸���.
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics�� �̿��ؼ� �׸��� �׸��ϴ�.", 10, 50);

		g.drawOval(50, 100, 50, 50);
		g.setColor(Color.blue);
		g.fillOval(100, 100, 50, 50);

		g.setColor(Color.red);
		g.drawLine(100, 100, 150, 150);

		g.fillRoundRect(200, 100, 120, 80, 30, 30);
		g.setColor(Color.orange);
		g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250, }, 4);
		// �ٰ����׸���
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120);
		// ȣ�׸���
	}

	public GraphicsEx1(String title) {
		super(title);
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		// Frame��(100,100)�� ��ġ�� width 400,height 300ũ��� ���̰� �Ѵ�.
		setBounds(100, 100, 400, 300);
		setVisible(true);
	}
}// class
