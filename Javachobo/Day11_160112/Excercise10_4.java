package Day11_160112;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Excercise10_4 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new EventHandler1());
	}
}

class EventHandler1 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(true);
		e.getWindow().dispose();
		System.exit(0);
	}
}
