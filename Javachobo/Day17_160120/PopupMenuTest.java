package Day17_160120;

import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuTest {
	public static void main(String[] args) {
		final Frame f = new Frame("PopupMenu Test");
		f.setSize(300, 200);

		final PopupMenu pMenu = new PopupMenu("Edit");
		MenuItem miCut = new MenuItem("Cut");
		MenuItem miCopy = new MenuItem("Copy");
		MenuItem miPaste = new MenuItem("Paste");
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);

		f.add(pMenu);// PopupMenu를 Frame에 추가한다.
		f.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {// mousePressed=>콜백메서드
														// 마우스클릭이 일어나면 동작
				// 오른쪽 마우스버튼을 누르는 경우에만 PopupMenu를 화면에 보여준다.
				if (me.getModifiers() == me.BUTTON3_MASK)
					pMenu.show(f, me.getX(), me.getY());
				//마우스를 클릭한 x,y좌표에 pMenu는 보여라.
			}
		});
		f.setVisible(true);

	}
}
