package Day18_160121;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;

public class ChatWin extends Frame {
	String nickname = "";

	TextArea ta = new TextArea();

	Panel p = new Panel();
	TextField tf = new TextField();

	ChatWin() {
		this("guest");
	}

	ChatWin(String nickname) {
		super("Chatting");//title�� Chatting���� �������������.
		this.nickname = nickname;

		setBounds(100, 100, 300, 200);

		p.setLayout(new BorderLayout());
		p.add(tf, "Center");//Panel�� �ֱ�

		add(ta, "Center");//Frame�� �ֱ�
		add(p, "South");

		addWindowListener(new WindowAdapter() {//x��ư������ �ý�������
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);

		ta.setText("#" + nickname + "�� ��ſ� ä�õǼ���.");
		ta.setEditable(false);

		setVisible(true);
		tf.requestFocus();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java ChatWin NICKNAME");
			System.exit(0);
		}
		new ChatWin(args[0]);
	}// main

	class EventHandler extends FocusAdapter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String msg = tf.getText();
			if ("".equals(msg))
				return;

			ta.append("\r\n" + nickname + ">" + msg);
			//\r Ŀ���� �� ���� ���� ù��°Ŀ���� �̵��մϴ�

			tf.setText("");
		}

		@Override
		public void focusGained(FocusEvent e) {
			tf.requestFocus();
			//tf
		}
	}// class EventHandler
}// class
