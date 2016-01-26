package Day17_160120;
import java.awt.*;
public class PanelTest {
public static void main(String[] args) {
	Frame f = new Frame("Panel");
	f.setSize(300,200);
	f.setLayout(null);//Frmae이 LayoutManager를 사용하지 않도록한다.
	
	Panel p = new Panel();
	p.setBackground(Color.green);//Panel의 배경을 green으로한다.
	p.setSize(100,100);
	p.setLocation(50,50);
	
	Button ok = new Button("OK");
	
	p.add(ok);//Butotn을 Panel에 포함시킨다.
	f.add(p);//Panel을 Frame에 포함시킨다.
	f.setVisible(true);
}
}
