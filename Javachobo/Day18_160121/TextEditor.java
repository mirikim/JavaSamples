package Day18_160121;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class TextEditor extends Frame {
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;

	TextEditor(String title) {

		super(title);//
		content = new TextArea();// TextArea생성
		add(content);

		mb = new MenuBar();
		mFile = new Menu("File");

		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");

		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator();// 메뉴 분리선(serparator)을 넣는다
		mFile.add(miExit);

		mb.add(mFile);// MenuBar에 Menu를 추가한다.
		setMenuBar(mb);// Frmae에 MenuBar를 포함시킨다.
		// 메뉴에 이벤트 핸들러를 등록한다.
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);

		setSize(300, 200);
		setVisible(true);

	}

	// 선택된 파일의 내용을 읽어서 TextArea에 보여주는 메서드
	void fileOpen(String fileName) {
		FileReader fr;
		BufferedReader br;
		StringWriter sw;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			sw = new StringWriter();

			int ch = 0;
			while ((ch = br.read()) != -1) {
				// 버퍼안에있는 텍스트들을 읽어올때사용하는 메서드.read() '-1'은 파일의 끝을 나타냄
				sw.write(ch);

			}
			br.close();// 스트림객체들은 사용이 끝나면 꼭 close()해줘야한다.
			content.setText(sw.toString());
			// sw안에있는 객체(파일의내용)들을 문자열로 리턴해준다
		} catch (IOException e) {
			// ex 파일이없는경우
			e.printStackTrace();
		}
	}// fileOpne메서드의 끝

	// TextArea의 내용을 지정된 파일에 저장하는 메서드
	void saveAs(String fileName) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content.getText());// TextArea의 내용을 파일에 저장한다.
			bw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		} // try
	}// saveAs메서드의 끝

	public static void main(String[] args) {
		TextEditor mainWin = new TextEditor("Text Editor");
	}// main 메서드의 끝

	// 메뉴를 클릭했을 대 메뉴별 처리코드
	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			// getActionCommand() : 액션을 발생시킨 명령을 문자열로 반환
			if (command.equals("New")) {
				content.setText("");
			} else if (command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(TextEditor.this, "파일열기");
				//TextEditor.this :다이얼로그가 어느객체에 속할것인지,"파일열기" :타이틀설정
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				//절대경로로 표시된 파일이름 : fileName
				System.out.println(fileName);
				// 선택된 파일의 내용을 TextArea에 보여준다.
				fileOpen(fileName);
			} else if (command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(TextEditor.this, "파일저장", FileDialog.SAVE);
				//FileDialog.SAVE : 다이얼로그의 모드설정
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory() + fileSave.getFile();
				System.out.println(fileName);
				// 현재 TextArea의 내용을 선택된 파일에 저장한다.
				saveAs(fileName);
			} else if (command.equals("Exit")) {
				System.exit(0);// 프로그램을 종료시킨다.
			}
		}
	}// class MyHandler
}// TextEdiotr클래스의끝
