package Day17_160120;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest2 {
	public static void main(String[] args) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);

		// parent frame을 f로하고 , modal을 true로해서 필수응답 dialog로 함
		final Dialog info = new Dialog(f, "Infomation", true);
		info.setSize(140, 90);
		info.setLocation(50, 50);// parent Frame이 아닌, 화면기준의 위치
		info.setLayout(new FlowLayout());

		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// OK버튼을 누르면 수행됨
				// TODO Auto-generated method stub
				// info.setVisible(false);//Dialog를안보이게한다.
				info.dispose();// Dialog를 메모리에서 없앤다.
			}
		});
		info.add(msg);
		info.add(ok);
		f.setVisible(true);
		info.setVisible(true);// Dialog를 화면에 보이게 한다.

	}
}
