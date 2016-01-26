package Day18_160121;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutEventTest extends Frame {
	Button first, prev, next, last;
	Panel buttons;
	Panel slide;
	Panel card1, card2, card3, card4, card5;// slide에 포함될 Panel들
	CardLayout card;

	public CardLayoutEventTest(String title) {
		// TODO Auto-generated constructor stub
		super(title);// 조상인 Frame의 생성자 FRame(String title)을 호출
		// 화면을 담을 Panel을 담는다.
		slide = new Panel();
		card = new CardLayout();
		slide.setLayout(card);

		// 버튼ㅇ르 담을 Panel을 만든다.
		buttons = new Panel();
		buttons.setLayout(new FlowLayout());

		first = new Button("<<");
		prev = new Button("<");
		next = new Button(">");
		last = new Button(">>");
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);

		// 버튼에 이벤트 리스너를 추가한다.
		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// CardLayout의 첫번 째 slide(panel)이 보이도록한다.
				card.first(slide);

			}
		});
		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 현재 slide의 이전 slide(Panel)이 보이도록한다.
				card.previous(slide);
			}
		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 현재 슬라이드의 다음 슬라이드가 보이도록한다.
				card.next(slide);

			}
		});
		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// cardLayout으 ㅣ마지막 슬라이드가 보이도록한다.
				card.last(slide);

			}
		});
		card1 = new Panel();
		card1.setBackground(Color.gray);
		card1.add(new Label("첫 번째 페이지입니다."));
		card2 = new Panel();
		card2.setBackground(Color.orange);
		card2.add(new Label("두 번째 페이지입니다."));

		card3 = new Panel();
		card3.setBackground(Color.blue);
		card3.add(new Label("세 번째 페이지입니다."));

		card4 = new Panel();
		card4.setBackground(Color.cyan);
		card4.add(new Label("네 번째 페이지입니다."));
		card5 = new Panel();
		card5.setBackground(Color.pink);
		card5.add(new Label("다섯 번째 페이지입니다."));

		// sldie(Panel)에 card1(Panel)을 "1"이란 이름으로 추가한다.
		slide.add(card1, "1");
		slide.add(card2, "2");
		slide.add(card3, "3");
		slide.add(card4, "4");
		slide.add(card5, "5");

		add("South", buttons);
		add("Center", slide);

		setSize(200, 200);
		setLocation(200, 200);
		setVisible(true);

		card.show(slide, "1");// 첫번째슬라이드가 나타나게한다.
	}

	public static void main(String[] args) {
		CardLayoutEventTest mainWid = new CardLayoutEventTest("CardLayoutTest");
	}
}
