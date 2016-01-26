package Day15_160118;

import java.util.*;
import java.io.*;

public class ScannerEx3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("data3.txt"));
		int cnt = 0;
		int totalSum = 0;

		while (sc.hasNextLine()) {
			String line = sc.nextLine();// 한 라인씩 스트링객체로 생성
			Scanner sc2 = new Scanner(line).useDelimiter(",");
			// useDlimiter라는 메서드를 사용해서 매개변수 문자열로 생성된 정규 표현식으로 구분 패턴을 지정한다.
			// ","를 이용해 데이터를 구분

			int sum = 0;

			while (sc2.hasNextInt()) {
				sum += sc2.nextInt();
			}
			System.out.println(line + ", sum = " + sum);
			totalSum += sum;
			cnt++;
		}
		System.out.println("Line : " + cnt + ", Total : " + totalSum);

	}
}
// 100,100,100 Comma Seperated Value
// 200,200,200
// 300,300,300
// 400,400,400
// 500,500,500
