package Day19_160122;

import java.awt.*;

public class HelloApplet extends java.applet.Applet{
	@Override
	public void paint(Graphics g) {
		setBackground(Color.lightGray);//���ø��� ������ ���� ȸ������ ����
		g.drawString("Hello,Applet.", 0, 0);
	}
}
