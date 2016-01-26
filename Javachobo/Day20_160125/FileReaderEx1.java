package Day20_160125;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "test.txt";
			FileInputStream fis = new FileInputStream(fileName);//����Ʈ���
			FileReader fr = new FileReader(fileName);//���ڱ��

			int data = 0;
			// fileInputStream�� �̿��ؼ� ���ϳ����� �о� ȭ�鿡 ����Ѵ�.
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);//����Ʈ����̹Ƿ� ���������
			}
			System.out.println();
			fis.close();

			// FileReader�� �̿��ؼ����ϳ����� �о� ȭ�鿡 ����Ѵ�.
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);//���ڱ���̹Ƿ� �ѱ��� �������ʴ´�.
			}
			System.out.println();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main
}
