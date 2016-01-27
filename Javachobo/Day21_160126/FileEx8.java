package Day21_160126;

import java.io.*;
import java.util.*;

public class FileEx8 {
	static int deletedFiles = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java FileEx8 Extendsion");
			System.exit(0);
		}

		String currDir = System.getProperty("user.dir");
	//	System.out.println(currDir);
		File dir = new File(currDir);
		String ext = "." + args[0];//. + txt.txt

		delete(dir, ext);
		System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
	}// end of main

	public static void delete(File dir, String ext) {
		File[] files = dir.listFiles();//폴더가 가진 객체 배열을 리스트로 받는것

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				delete(files[i], ext);
			} else {//파일인경우
				String filename = files[i].getAbsolutePath();

				if (filename.endsWith(ext)) {
					System.out.print(filename);
					if (files[i].delete()) {//파일을 삭제하는메서드 .delete()
						System.out.println(" - 삭제 성공");
						deletedFiles++;
					} else {
						System.out.println(" - 삭제 실패");
					}
				} // if(filename.endsWith(ext)){
			} // if(files[i].isDirectory()){
		} // for(int i=0;i<files.length;i++){
	}// end of delete;
}// end of class
