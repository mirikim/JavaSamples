package Day11_160112;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {//

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ActionEvent occurred!!!");
			}
		}// 익명클래스의 끝( 객체의 생성과 선언을 동시에하는 익명클래스)
		);
	}// main메서드의 끝
}// InnerEx8클래스의 끝
