package Day17_160120;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class FontTest {
	public static void main(String[] args) {
		Frame f = new Frame("Font Test");
		String abc = "ABCDDFGHIJKLMNOPQRSTUVWXYZ";

		// A-Z를 내용으로 갖는 Label들을 생성한다.
		Label abc1 = new Label(abc);
		Label abc2 = new Label(abc);
		Label abc3 = new Label(abc);
		Label abc4 = new Label(abc);
		Label abc5 = new Label(abc);

		// Serif체이며,크기가 20인 Font
		Font f1 = new Font("Serif", Font.PLAIN, 20);// 보통체
		Font f2 = new Font("Serfit", Font.ITALIC, 20);// 기울임체
		Font f3 = new Font("Serif", Font.BOLD, 20);// 굵은체
		Font f4 = new Font("Serif", Font.BOLD + Font.ITALIC, 20);// 굵은 기울임체

		abc1.setFont(f1);// Label에 새로운 Font를 적용한다.
		abc2.setFont(f2);
		abc3.setFont(f3);
		abc4.setFont(f4);
		f.setBackground(Color.CYAN);
		f.setLayout(new FlowLayout());
		f.add(abc1);
		f.add(abc2);
		f.add(abc3);
		f.add(abc4);
		f.add(abc5);

		f.setSize(400, 300);
		f.setVisible(true);
	}
}
