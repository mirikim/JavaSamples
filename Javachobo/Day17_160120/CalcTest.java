package Day17_160120;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Line2D;

public class CalcTest {
	public static void main(String[] args) {
		Frame f = new Frame("계산기");
		TextField tf = new TextField("0");

		tf.setEditable(false);
		tf.setSize(400, 50);
		f.setSize(300, 200);
		f.setLocation(200, 200);
		f.add("North", tf);
		//////// Menu/////////
		MenuBar(f);

		///// Panel//////////
		NumPanel(f);
		FuncPanel(f);

		// Listener
		f.addWindowListener(new EventHandler());
		f.setResizable(false);
		f.setVisible(true);
	}

	// MenuBar
	static void MenuBar(Frame f) {
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("보기");

		MenuItem mi1 = new MenuItem("일반용");
		MenuItem mi2 = new MenuItem("공학용");
		MenuItem mi3 = new MenuItem("프로그래머용");
		MenuItem mi4 = new MenuItem("통계용");
		MenuItem mi5 = new MenuItem("기록");
		MenuItem mi6 = new MenuItem("자리수구분단위");
		MenuItem mi7 = new MenuItem("기본");
		MenuItem mi8 = new MenuItem("단위변환");
		MenuItem mi9 = new MenuItem("날짜계산");

		Menu mWorksheet = new Menu("워크시트");// MenuItem이 아니라 Menu임에 주의
		mFile.add(mi1);// Menu에 MenuItem을 추가한다.
		mFile.add(mi2);
		mFile.add(mi3);
		mFile.add(mi4);
		mFile.addSeparator();// 메뉴분리선을 넣는다.
		mFile.add(mi5);
		mFile.add(mi6);
		mFile.addSeparator();// 메뉴분리선을 넣는다.
		mFile.add(mi7);
		mFile.add(mi8);
		mFile.add(mi9);
		mFile.add(mWorksheet);// Menu에 Menu를 추가한다.

		MenuItem miw1 = new MenuItem("주택담보대출");
		MenuItem miw2 = new MenuItem("자동차임대");
		MenuItem miw3 = new MenuItem("연비계산(mpg)");
		MenuItem miw4 = new MenuItem("연비계산(L/100km)");
		// ...는 서브메뉴를 갖고있을 수 있다는 의미.

		mWorksheet.add(miw1);
		mWorksheet.add(miw2);
		mWorksheet.add(miw3);
		mWorksheet.add(miw4);

		Menu mEdit = new Menu("편집");
		MenuItem mie1 = new MenuItem("복사");
		MenuItem mie2 = new MenuItem("붙여넣기");
		mEdit.add(mie1);
		mEdit.add(mie2);

		Menu mHelp = new Menu("도움말");
		MenuItem mih1 = new MenuItem("도움말보기");
		MenuItem mih2 = new MenuItem("계산기정보");
		mHelp.add(mih1);
		mHelp.addSeparator();// 메뉴분리선을 넣는다.
		mHelp.add(mih2);

		// CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");

		mb.add(mFile); // MenuBar에 Menu를 추가한다.
		mb.add(mEdit);
		mb.add(mHelp);
		// mb.setHelpMenu(mHelp);// mHelp를 HelpMenu로 지정한다.

		f.setMenuBar(mb);

	}

	// NumPanel
	static void NumPanel(Frame f) {
		Panel numPanel = new Panel();
		Button[] numBottons = null;
		numPanel.setLayout(new GridLayout(6, 5, 4, 4));
		numPanel.setSize(150, 150);
		numPanel.setBackground(Color.lightGray);
	

		String numStr[] = { "MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±", "√", "7", "8", "9", "/", "%", "4", "5",
				"6", "*", "1/x", "1", "2", "3", "-", "=", "0", "", ".", "+", " " };

		numBottons = new Button[numStr.length];
		for (int i = 0; i < numStr.length; i++) {
			numBottons[i] = new Button(numStr[i]);
			numBottons[i].setForeground(Color.blue);
			numPanel.add(numBottons[i]);

		}
		numBottons[20].setSize(200, 10);
		f.add("East", numPanel);
	}

	// FuncPanel
	static void FuncPanel(Frame f) {
		Panel funcPanel = new Panel();
		Panel checkPanel = new Panel();
		Panel buttonPanel = new Panel();
		Button[] funcBottons = null;
		buttonPanel.setLayout(new GridLayout(2, 1));
		buttonPanel.setSize(200, 150);

		checkPanel.setLayout(new GridLayout(1, 3));
		checkPanel.setSize(100, 10);
		checkPanel.setBackground(Color.lightGray);
		CheckboxGroup group = new CheckboxGroup();
		Checkbox deg = new Checkbox("Degrees", group, true);
		Checkbox rad = new Checkbox("Radians", group, false);
		Checkbox gra = new Checkbox("Grads", group, false);
		// Button b1 = new Button("");
		// Button b2 = new Button("");
		// funcPanel.add(b1);
		checkPanel.add("North", deg);
		checkPanel.add("North", rad);
		checkPanel.add("North", gra);

		// funcPanel.add(b2);
		funcPanel.setLayout(new GridLayout(5, 5, 4, 4));
		funcPanel.setSize(150, 100);
		funcPanel.setBackground(Color.lightGray);

		String funcStr[] = { "", "lnv", "ln", "(", ")", "Int", "sinh", "sin", "x²", "n!", "dms", "cosh", "cos", "x^y",
				"ⁿ√x", "pi", "tanh", "tan", "x³", "³√x", "F-E", "Exp", "Mod", "log", "10x" };
		funcBottons = new Button[funcStr.length];
		for (int i = 0; i < funcStr.length; i++) {

			funcBottons[i] = new Button(funcStr[i]);
			funcBottons[i].setForeground(Color.blue);
			funcPanel.add(funcBottons[i]);

		}
		buttonPanel.add(checkPanel, "North");
		buttonPanel.add(funcPanel, "Center");

		f.add(buttonPanel);
	}
}

class EventHandler2 implements WindowListener {
	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		// Frame의 닫기 버튼을 눌렀을 때 호출된다.
		e.getWindow().setVisible(false);// Frame을 화면에서 보이지 않도록 하고
		e.getWindow().dispose();// 메모리에서 제거한다.
		System.exit(0);// 프로그램을 종료한다.
	}

	public void windowClosed(WindowEvent e) {
	}// 아무내용도 없는 메서드 구현

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActiated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
