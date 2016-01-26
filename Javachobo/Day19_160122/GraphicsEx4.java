package Day19_160122;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx4 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;
	Image img = null;
	Graphics gImg = null;

	public static void main(String[] args) {
		new GraphicsEx4("GraphicsEx4");
	}

	public GraphicsEx4(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent me) {
				System.exit(0);
			}
		});

		// Frame은 (100,100)의 위치에 width 500, height 500크기로 보이게 한다.
		setBounds(100, 100, 500, 500);
		setVisible(true);

		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("왼쪽버튼을 누른 채로 마우스를 움직여보세요", 10, 50);
		repaint();
	}

	public void paint(Graphics g) {
		if (img != null)
			g.drawImage(img, 0, 0, this);
		// 가상화면에 그려진 그림을 Frame에 복사
	}

	
	public void mouseMoved(MouseEvent me) {
	}

	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			x = me.getX();
			y = me.getY();
			gImg.drawString("*", x, y);
			repaint();
		}
	}
}// class
