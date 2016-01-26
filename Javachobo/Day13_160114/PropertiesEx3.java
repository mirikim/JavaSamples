package Day13_160114;

import java.util.*;
import java.io.*;

public class PropertiesEx3 {
	public static void main(String[] args) {
		Properties prop = new Properties();

		prop.setProperty("timeout", "30");
		prop.setProperty("language", "한글");
		prop.setProperty("size", "10");
		prop.setProperty("cappacity", "10");

		try {

			prop.store(new FileOutputStream("output.txt"), "Properties Example");
			// 저장된 목록을 지정된 출력스트림에 출력(저장)한다.
			// header는 목록에 대한 설명(주석)으로 저장된다.
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
			// 저장된 목록을 지정된 출력스트림에 XML문서로 출력(저장)한다.
			// comment는 목록에 대한 설명(주석)으로 저장된다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
