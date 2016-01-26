package Day17_160120;

import java.awt.*;

public class DialogTest {
	public static void main(String[] args){
		Frame f = new Frame("Parent");
		f.setSize(300, 200);

		// parent Frame을 f로하고, modal을 true로해서 필수응답 Dialog로함.
		Dialog info = new Dialog(f, "Infomation", true);
		info.setSize(140, 90);
		info.setLocation(50, 50);// parent Frame이 아닌 화면이위치의 기준이된다.
		info.setLayout(new FlowLayout());

		Label msg = new Label("This is modal Dialog", Label.LEFT);
		Button ok = new Button("OK");
		info.add(msg);
		info.add(ok);

		f.setVisible(true);
		
		info.setVisible(true);//Dialog를화면에보이게
	}
}
