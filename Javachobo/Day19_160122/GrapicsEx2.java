package Day19_160122;

import java.awt.*;
import java.awt.event.*;

public class GrapicsEx2 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	public static void main(String[] args) {
		new GrapicsEx2("GraphicsEx2");
	}

	public GrapicsEx2(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		// Frame을 (100,100)의 위치에 width 500 height 500크기로 보이게 한다.
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("마우스를 움직여보세요", 10, 50);
		g.drawString("*", x, y);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		x = me.getX();
		y = me.getY();
		repaint();
	}

	public void mouseDragged(MouseEvent me) {
	}
}
