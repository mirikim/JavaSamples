package Day11_160112;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

public class Excercise10_4_1 {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				e.getWindow().setVisible(true);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
}
