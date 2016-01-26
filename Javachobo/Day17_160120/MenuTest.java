package Day17_160120;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class MenuTest {
	public static void main(String[] args) {
		Frame f = new Frame("Frame with Menu");
		f.setSize(300, 200);

		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("File");

		MenuItem miNew = new MenuItem("New");
		MenuItem miOpen = new MenuItem("Open");
		Menu mOthers = new Menu("Others");// MenuItem이 아니라 Menu임에 주의
		MenuItem miExit = new MenuItem("Exit");

		mFile.add(miNew);// Menu에 MenuItem을 추가한다.
		mFile.add(miOpen);
		mFile.add(mOthers);// Menu에 Menu를 추가한다.
		mFile.addSeparator();// 메뉴분리선을 넣는다.
		mFile.add(miExit);

		MenuItem miPrint = new MenuItem("Print...");
		MenuItem miPreiview = new MenuItem("Print Preview");
		MenuItem miSetup = new MenuItem("Print Setup...");
		//...는 서브메뉴를 갖고있을 수 있다는 의미.
		
		
		mOthers.add(miPrint);
		mOthers.add(miPreiview);
		mOthers.add(miSetup);

		Menu mEdit = new Menu("Edit");
		Menu mView = new Menu("View");
		Menu mHelp = new Menu("Help");
		CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
		mView.add(miStatusbar);

		mb.add(mFile); // MenuBar에 Menu를 추가한다.
		mb.add(mEdit);
		mb.add(mView);
		mb.setHelpMenu(mHelp);// mHelp를 HelpMenu로 지정한다.

		f.setMenuBar(mb);// Frame에 MenuBar를 포함시킨다.
		f.setVisible(true);
	}
}
