package Day19_160122;

////������/////////////////�����ּ���
//////////////�˻��޴�.: ã��ٲٱ� �߰� 
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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TextEditorTest extends Frame {
	String fileName;
	static TextArea content;
	MenuBar mb;
	Menu mFile, mSearch;
	MenuItem miNew, miOpen, miSaveAs, miExit, mFindReplace;

	TextEditorTest(String title) {

		super(title);//
		content = new TextArea();// TextArea����
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
		mFile.addSeparator();// �޴� �и���(serparator)�� �ִ´�
		mFile.add(miExit);

		mSearch = new Menu("Search");
		mFindReplace = new MenuItem("Find/Replace");

		mSearch.add(mFindReplace);

		mb.add(mFile);// MenuBar�� Menu�� �߰��Ѵ�.
		mb.add(mSearch);
		setMenuBar(mb);// Frmae�� MenuBar�� ���Խ�Ų��.
		// �޴��� �̺�Ʈ �ڵ鷯�� ����Ѵ�.

		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);
		mFindReplace.addActionListener(handler);

		setSize(300, 200);
		setVisible(true);

	}

	// ���õ� ������ ������ �о TextArea�� �����ִ� �޼���
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
				// ���۾ȿ��ִ� �ؽ�Ʈ���� �о�ö�����ϴ� �޼���.read() '-1'�� ������ ���� ��Ÿ��
				sw.write(ch);

			}
			br.close();// ��Ʈ����ü���� ����� ������ �� close()������Ѵ�.
			content.setText(sw.toString());
			// sw�ȿ��ִ� ��ü(�����ǳ���)���� ���ڿ��� �������ش�
		} catch (IOException e) {
			// ex �����̾��°��
			e.printStackTrace();
		}
	}// fileOpne�޼����� ��

	// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼���
	void saveAs(String fileName) {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content.getText());// TextArea�� ������ ���Ͽ� �����Ѵ�.
			bw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		} // try
	}// saveAs�޼����� ��

	//TextArea�� ���뿡�� Ư�� ���ڸ� ã�� �޼��� 
	static void Find(String findText) {
		ArrayList result = new ArrayList();
		String Data = content.getText();

		for (int i = 0; i < Data.length(); i++) {
			if (findText.charAt(0) == (Data.charAt(i))) {
				// JOptionPane.showConfirmDialog(this, Data.charAt(i) + "��
				// ã�ҽ��ϴ�.");
				result.add(Data.charAt(i));
			} else {

			}
		}

		if (result.size() == 0) {
			JOptionPane.showMessageDialog(null, "�ش� ���ڰ� �����ϴ�.");
		} else {
			int findresult = JOptionPane.showConfirmDialog(null,
					"ã���ô� ���� '" + findText + "'�� " + result.size() + "�� ã�ҽ��ϴ�. �ٸ� ���ڷ� �ٲٽ÷��� 'Ȯ�� '��ư�� �����ּ���.", "Find",
					JOptionPane.OK_CANCEL_OPTION);
			if (findresult == 0) {
				String ReplaceText = JOptionPane.showInputDialog("�ٲٽ� �� ���ڸ� �Է����ּ���. ex)��,A,a,1,��... ");
				if (ReplaceText.length() == 1) {
					Replace(findText, ReplaceText);
				} else {
					JOptionPane.showMessageDialog(null, "�ٲٽ� �� ���ڸ� �ٽ� �Է����ּ���.");
				}
			}
		}

	}//Find�޼����� �� 
	
	//TextArea���� ã�� ���ڸ� �ٸ����ڷ� �ٲٴ� �޼��� 
	static void Replace(String findText, String ReplaceText) {
		StringWriter sw = new StringWriter();
		String Data = content.getText();
		String resultReplace = "";
		resultReplace = Data.replace(findText, ReplaceText);
		//System.out.println(resultReplace);
		sw.write(resultReplace);
		content.setText(sw.toString());

	}//Replace�޼����� ��

	public static void main(String[] args) {
		TextEditorTest mainWin = new TextEditorTest("Text Editor");

	}// main �޼����� ��

	// �޴��� Ŭ������ �� �޴��� ó���ڵ�
	class MyHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			// getActionCommand() : �׼��� �߻���Ų ����� ���ڿ��� ��ȯ
			if (command.equals("New")) {
				content.setText("");
			} else if (command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(TextEditorTest.this, "���Ͽ���");
				// TextEditor.this :���̾�αװ� �����ü�� ���Ұ�����,"���Ͽ���" :Ÿ��Ʋ����
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				// �����η� ǥ�õ� �����̸� : fileName
				System.out.println(fileName);
				// ���õ� ������ ������ TextArea�� �����ش�.
				fileOpen(fileName);
			} else if (command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(TextEditorTest.this, "��������", FileDialog.SAVE);
				// FileDialog.SAVE : ���̾�α��� ��弳��
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory() + fileSave.getFile();
				System.out.println(fileName);
				// ���� TextArea�� ������ ���õ� ���Ͽ� �����Ѵ�.
				saveAs(fileName);
			} else if (command.equals("Exit")) {
				System.exit(0);// ���α׷��� �����Ų��.
			} else if (command.equals("Find/Replace")) {
				String FindText = JOptionPane.showInputDialog("ã���� �� ���ڸ� �Է����ּ���. ex)��,A,a,1,��... ");
				if (FindText.length() == 1) {
					Find(FindText);
				} else {
					JOptionPane.showMessageDialog(TextEditorTest.this, "�� ���ڸ� �ٽ� �Է����ּ���.");
				}
			}
		}
	}// class MyHandler
}// TextEdiotrŬ�����ǳ�
