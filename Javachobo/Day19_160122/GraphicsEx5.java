package Day19_160122;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx5 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	Image img = null;
	Graphics gImg = null;

	public static void main(String[] args) {
		new GraphicsEx5("GraphicsEx5");
	}

	public GraphicsEx5(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		// Framd�� (100,100)�� ��ġ�� width 500, height 500 ũ��� ���̰��Ѵ�.
		setBounds(100, 100, 500, 500);
		setVisible(true);

		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("���ʺ����� ����ä�� ���콺�� ������������.", 10, 10);
		repaint();

	}

	@Override
	public void paint(Graphics g) {
		if (img == null)
			return;
		g.drawImage(img, 0, 0, this);// ����ȭ�鿡 �׷��� �׸��� Frame�� ����

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		x = me.getX();
		y = me.getY();

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) {
			return;
		}
		gImg.drawLine(x, y, me.getX(), me.getY());
		x = me.getX();
		y = me.getY();

		repaint();
	}
}// calss
