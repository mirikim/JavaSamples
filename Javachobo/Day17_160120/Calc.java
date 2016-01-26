package Day17_160120;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Calc {
	public static void main(String[] args) {
		Frame f = new Frame("계산기");
		TextField tf = new TextField("0");
		tf.setEditable(false);
		f.setSize(190, 160);
		f.setLocation(300, 300);

		f.add("North", tf);
		Panel numPanel = new Panel();
		Button[] numBottons = null;
		numPanel.setLayout(new GridLayout(4, 5, 4, 4));
		numPanel.setBackground(Color.lightGray);
		f.add("Center", numPanel);

		String numStr[] = { "7", "8", "9", "/", "CE", "4", "6", "6", "*", "BS", "1", "2", "3", "-", "1/x", "0", "+/-",
				".", "+", "=" };
		numBottons = new Button[numStr.length];
		for (int i = 0; i < numStr.length; i++) {
			numBottons[i] = new Button(numStr[i]);
			numBottons[i].setForeground(Color.blue);
			numPanel.add(numBottons[i]);

		}
		f.setResizable(false);
		f.setVisible(true);
	}
}
