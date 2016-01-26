package Day17_160120;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardLayoutTest {
	public static void main(String[] args) {
		final Frame f = new Frame("CardLayoutTest");
		final CardLayout card = new CardLayout(10, 10);
		//hgap,vgap 컨테이너와 cardlayout사이에 간격을 준다.
		f.setLayout(card);

		Panel card1 = new Panel();
		card1.setBackground(Color.lightGray);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.orange);
		Panel card3 = new Panel();
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.cyan);

		f.add(card1, "1");// Frame에 card1를 "1"이라고 이름붙여추가한다.
		f.add(card2, "2");
		f.add(card3, "3");

		class Handler extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 오른쪽버튼을 눌렀을때
				if (e.getModifiers() == e.BUTTON3_MASK) {
					card.previous(f);// CardLayout의 이전 Panel을 보여준다.
				} else {
					card.next(f);// CardLayout의 다음 Pannle을 보여준다.
				}
			}
		}// class Handler

		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		f.setSize(200, 200);
		f.setLocation(200, 200);
		f.setVisible(true);

		card.show(f, "1");// Frame에 추가된 Component중 이름이 "1"인 것을 보여준다.

	}
}
