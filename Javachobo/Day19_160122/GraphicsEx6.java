package Day19_160122;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx6 extends Frame {
	Image img = null;

	public GraphicsEx6(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("C:\\Academy\\JAVA\\workspace\\javaimg.png");
		

		setBounds(100, 100, 400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicsEx6("GraphicsEx6");
	}

	@Override
	public void paint(Graphics g) {
		if (img == null) {
			return;
		}

		// Image의 크기를 얻는다.
		int imgWidth = img.getWidth(this);// getWidth(ImageObserver obj)
		int imgHeight = img.getHeight(this);
		// 이미지를 Frame의 중앙에 출력한다.
		g.drawImage(img, (getWidth() - imgWidth) / 2, (getHeight() - imgHeight) / 2, this);
	}
}// class
