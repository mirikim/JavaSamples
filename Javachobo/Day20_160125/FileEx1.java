package Day20_160125;

import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
		File f = new File("C:\\Academy\\JAVA\\workspace\\JavaSample\\src\\Day20_160125\\FileEx1.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("��θ� ������ �����̸� - " + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸� - " + fileName.subSequence(0, pos));
		System.out.println("Ȯ���� - " + fileName.substring(pos + 1));

		System.out.println("��θ� ������ �����̸� - " + f.getPath());
		System.out.println("������ ������        - " + f.getAbsolutePath());
		System.out.println("������ ���� �ִ� ���丮 - " + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar -" + File.pathSeparatorChar);
		System.out.println("File.separator - " + File.separator);
		System.out.println("File.separatorChar -" + File.separatorChar);
		System.out.println();
		System.out.println("user.dir =" + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path =" + System.getProperty("sun.boot.class.path"));

	}
}
