package Day13_160114;

import java.io.*;
import java.util.*;

public class PropertiesEx2 {
	public static void main(String[] args) {
		// commandline에서 inputfile을 지정해주지 않으면 프로그램을 종료한다.
		if (args.length != 1) {
			System.out.println("USAGE : java PropertiesEx2 INPUTFILENAME");
			System.exit(0);
		}

		Properties prop = new Properties();

		String inputFile = args[0];

		try {
			prop.load(new FileInputStream(inputFile));
			//load();지정된 InputStream으로부터목록을 읽어서 저장한다. 
		} catch (IOException e) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			System.exit(0);
		}

		String name = prop.getProperty("name");
		//지정된 키(name)의 값을 반환한다.
		String[] data = prop.getProperty("data").split(",");
		//메서드split(String regex)는 regex의 표현에 따라 나누는 것.
		int max = 0;
		int min = 0;
		int sum = 0;

		for (int i = 0; i < data.length; i++) {
			int intValue = Integer.parseInt(data[i]);
			if (i == 0)
				max = min = intValue;

			if (max < intValue) {
				max = intValue;
			} else if (min > intValue) {
				min = intValue;
			}

			sum += intValue;
		}

		System.out.println("이름 : " + name);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum * 100.0 / data.length) / 100);
	}
}