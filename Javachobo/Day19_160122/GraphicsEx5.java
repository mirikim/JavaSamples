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
		// Framd을 (100,100)의 위치에 width 500, height 500 크기로 보이게한다.
		setBounds(100, 100, 500, 500);
		setVisible(true);

		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("왼쪽보턴을 누른채로 마우스를 움직여보세요.", 10, 10);
		repaint();

	}

	@Override
	public void paint(Graphics g) {
		if (img == null)
			return;
		g.drawImage(img, 0, 0, this);// 가상화면에 그려진 그림을 Frame에 복사

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
