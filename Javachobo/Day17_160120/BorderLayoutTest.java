package Day17_160120;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class BorderLayoutTest {
	public static void main(String[] args) {
		Frame f = new Frame("BorderLayoutTest");
		f.setSize(200, 200);

		// Frame은 기본적으로 BorderLayout으로 설정되어있으므로 따로 설정하지 않아도 됨
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button east = new Button("East");
		Button west = new Button("West");
		Button center = new Button("Center");
		north.setBackground(Color.pink);
		south.setBackground(Color.gray);
		east.setBackground(Color.blue);
		west.setBackground(Color.CYAN);
		center.setBackground(Color.DARK_GRAY);

		// Frame의 5개의 각 영역에 Button을 하나씩 추가한다.
		f.add(north, "North");// f.add("North",north);와 같이 쓸수도있다.
		f.add(south, "South");
		f.add(east, "East");
		f.add(west, "West");
		f.add(center, "Center");

		f.setVisible(true);
	}

}
