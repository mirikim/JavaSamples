package Day17_160120;
import java.awt.*;
public class TextAreaTest {
	public static void main(String[] args) {
Frame f = new Frame("comments");
f.setSize(400,220);
f.setLayout(new FlowLayout());

TextArea comments = new TextArea("하고 싶은 말을 적으세요.",10,50);
f.add(comments);
comments.selectAll();//TextArea의 text전체가 선택되도록한다.
f.setVisible(true);
	}
}
