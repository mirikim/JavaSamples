package Day17_160120;

import java.awt.FileDialog;
import java.awt.Frame;

public class FileDialogTest {
	public static void main(String[] args) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);

		FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);

		f.setVisible(true);
		fileOpen.setDirectory("C:\\Academy\\JAVA\\src\\src\\java\\awt");
		fileOpen.setVisible(true);

		// 파일은 선택한 다음, FileDialog의 열기버튼을 누르면,
		// getFile()과 getDirectory()를 이용해서 파일이름과 위치한 디렉토리를 얻을수있다.
		System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
	}
}
