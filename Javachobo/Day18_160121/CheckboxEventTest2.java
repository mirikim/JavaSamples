package Day18_160121;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.EventHandler;

public class CheckboxEventTest2 extends Frame {
	CheckboxGroup group;
	Checkbox cb1;
	Checkbox cb2;
	Checkbox cb3;

	public CheckboxEventTest2(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		group = new CheckboxGroup();
		cb1 = new Checkbox("red", group, true);
		cb2 = new Checkbox("green", group, false);
		cb3 = new Checkbox("blue", group, false);

		cb1.addItemListener(new EventHandler());
		cb2.addItemListener(new EventHandler());
		cb3.addItemListener(new EventHandler());

		setLayout(new FlowLayout());
		add(cb1);
		add(cb2);
		add(cb3);
		setBackground(Color.red);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		CheckboxEventTest2 mainWin = new CheckboxEventTest2("CheckboxEventTest2");
	}// main�޼����� ��

	class EventHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			Checkbox cb = (Checkbox) e.getSource();
			String color = cb.getLabel();

			if (color.equals("red")) {
				setBackground(Color.red);
			} else if (color.equals("green")) {
				setBackground(Color.green);
			} else {
				setBackground(Color.blue);
			}
		}
	}// class EventHandler
}
