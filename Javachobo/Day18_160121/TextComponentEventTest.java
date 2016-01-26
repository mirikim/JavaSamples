package Day18_160121;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextComponentEventTest extends Frame {
	TextField tf = new TextField();
	TextArea ta = new TextArea();

	public TextComponentEventTest(String title) {
		// TODO Auto-generated constructor stub

		super(title);// Frame(String title)을 호출한다.

		tf = new TextField();
		ta = new TextArea();
		add(ta, "Center");
		add(tf, "South");

		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TextField에서 Enter를 치면, ,tf에 입력된 text를 TextArea에 추가한다.
				ta.append(tf.getText() + "\n");
				tf.setText("");// tf의 text를 지운다.
				tf.requestFocus();
			}
		});

		ta.setEditable(false);// TextArea의 text를 편집하지 못하게 한다.
		setSize(300, 200);
		setVisible(true);
		tf.requestFocus();// focus가 TextField에 위치하도록한다.
	}

	public static void main(String[] args) {
		TextComponentEventTest mainWin = new TextComponentEventTest("TextComponentEventTest");
	}// main메서드의 끝

}
