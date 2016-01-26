package Day15_160118;

import java.io.*;
import java.util.*;

/*성적 처리 프로그램*/
public class ScannerEx4 {
	public static void main(String[] args) throws FileNotFoundException {
		Score score = new Score();
		Scanner sc = new Scanner(new File("scoreData.txt"));

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line).useDelimiter(",");

			score.add(sc2.next(), sc2.next(), sc2.nextInt(), sc2.nextInt(), sc2.nextInt());
		}

		score.displayList();
	}
} // class ScannerEx4

class Score {// 성적데이터를 저장 출력 클래스
	ArrayList record = new ArrayList();

	int koreanTotal = 0;
	int mathTotal = 0;
	int englishTotal = 0;
	// 성적데이터는 순서적이며 늘어날수있다.=> ArrayList에저장

	void add(String name, String studentNo, int koreanScore, int mathScore, int englishScore) {
		// 학생객체 생성
		Student s = new Student(name, studentNo, koreanScore, mathScore, englishScore);
		record.add(s);// arrayList에 학생객체 s를 넣는다.
		koreanTotal += s.koreanScore;
		mathTotal += s.mathScore;
		englishTotal = s.englishScore;
	}

	int getSubjectTotal() {// 국영수총점
		return koreanTotal + mathTotal + englishTotal;
	}

	void displayList() {// 출력포맷 디자인
		if (record.size() == 0) {
			System.out.println("표시할 데이터가 없습니다.");
			return;
		}
		System.out.println(" 이름   번호  국어  수학  영어    총점 ");
		System.out.println("=======================================");

		for (int i = 0; i < record.size(); i++) {
			System.out.println((Student) record.get(i));
			// arrayList에있는 정보를 가져오는데 Stduent객체타입으로
		}

		System.out.println("=======================================");
		System.out.println(Student.format("" + record.size(), 2, Student.RIGHT) + "명 총점 : "
				+ Student.format("" + koreanTotal, 5, Student.RIGHT) + Student.format("" + mathTotal, 6, Student.RIGHT)
				+ Student.format("" + englishTotal, 6, Student.RIGHT)
				+ Student.format("" + getSubjectTotal(), 8, Student.RIGHT));
	}// void idsplayList()
}// class Score

class Student {
	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;

	String name = "";
	String studentNo = "";
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;

	// 생성자메서드
	Student(String name, String studentNo, int koreanScore, int mathScore, int englishScore) {
		this.name = name;
		this.studentNo = studentNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
	}

	int getTotal() { // 학생별 총점
		return koreanScore + mathScore + englishScore;
	}

	public String toString() {
		return format(name, 4, LEFT) + format(studentNo, 4, RIGHT) + format("" + koreanScore, 6, RIGHT)
				+ format("" + mathScore, 6, RIGHT) + format("" + englishScore, 6, RIGHT)
				+ format("" + getTotal(), 8, RIGHT);
	}

	static String format(String str, int length, int alignment) {
		int diff = length - str.length();

		if (diff < 0)
			return str.substring(0, length);// 이름 return

		char[] source = str.toCharArray();// string을 Char배열로 변환
		char[] result = new char[length];

		// 배열 result를 공백으로 채운다.
		for (int i = 0; i < result.length; i++) {
			result[i] = ' ';
		}

		switch (alignment) {
		case CENTER:// 가운데정렬
			System.arraycopy(source, 0, result, diff / 2, source.length);//배열 복사 arraycopy
			break;

		case RIGHT:// 오른쪽정렬
			System.arraycopy(source, 0, result, diff, source.length);
			break;

		case LEFT:// 왼쪽정렬

		default:// 기본값이 왼쪽정렬이므로
			System.arraycopy(source, 0, result, 0, source.length);

			break;
		}
		return new String(result);
	} // static String format(String str, int length, int alignment){
} // class Student {