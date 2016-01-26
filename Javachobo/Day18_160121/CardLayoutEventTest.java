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
	Panel card1, card2, card3, card4, card5;// slide�� ���Ե� Panel��
	CardLayout card;

	public CardLayoutEventTest(String title) {
		// TODO Auto-generated constructor stub
		super(title);// ������ Frame�� ������ FRame(String title)�� ȣ��
		// ȭ���� ���� Panel�� ��´�.
		slide = new Panel();
		card = new CardLayout();
		slide.setLayout(card);

		// ��ư���� ���� Panel�� �����.
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

		// ��ư�� �̺�Ʈ �����ʸ� �߰��Ѵ�.
		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// CardLayout�� ù�� ° slide(panel)�� ���̵����Ѵ�.
				card.first(slide);

			}
		});
		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ���� slide�� ���� slide(Panel)�� ���̵����Ѵ�.
				card.previous(slide);
			}
		});
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ���� �����̵��� ���� �����̵尡 ���̵����Ѵ�.
				card.next(slide);

			}
		});
		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// cardLayout�� �Ӹ����� �����̵尡 ���̵����Ѵ�.
				card.last(slide);

			}
		});
		card1 = new Panel();
		card1.setBackground(Color.gray);
		card1.add(new Label("ù ��° �������Դϴ�."));
		card2 = new Panel();
		card2.setBackground(Color.orange);
		card2.add(new Label("�� ��° �������Դϴ�."));

		card3 = new Panel();
		card3.setBackground(Color.blue);
		card3.add(new Label("�� ��° �������Դϴ�."));

		card4 = new Panel();
		card4.setBackground(Color.cyan);
		card4.add(new Label("�� ��° �������Դϴ�."));
		card5 = new Panel();
		card5.setBackground(Color.pink);
		card5.add(new Label("�ټ� ��° �������Դϴ�."));

		// sldie(Panel)�� card1(Panel)�� "1"�̶� �̸����� �߰��Ѵ�.
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

		card.show(slide, "1");// ù��°�����̵尡 ��Ÿ�����Ѵ�.
	}

	public static void main(String[] args) {
		CardLayoutEventTest mainWid = new CardLayoutEventTest("CardLayoutTest");
	}
}
