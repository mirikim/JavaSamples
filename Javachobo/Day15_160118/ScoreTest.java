package Day15_160118;

import java.io.*;
import java.text.Format;
import java.util.*;

public class ScoreTest {
	static ArrayList record = new ArrayList();
	// 배열의 길이가 조절이 가능한 Arraylist에 저장(학생을 입력/삭제하므로)
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				deleteRecord();
				break;
			case 3:
				sortRecord();
				break;

			case 4:
				printSpecificStudent();
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}
		} // while(true)
	}

	// menu를 보여주는 메서드
	static int displayMenu() {
		System.out.println("***************************************************");
		System.out.println("*               성적 관리 프로그램                *");
		System.out.println("*                   version 1.0                   *");
		System.out.println("*            excerpt from Java의 정석             *");
		System.out.println("***************************************************");
		System.out.println();
		System.out.println();
		System.out.println(" 1. 학생성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 학생성적 삭제하기 ");
		System.out.println();
		System.out.println(" 3. 학생성적 정렬하여보기(이름순, 성적순)");
		System.out.println();
		System.out.println(" 4. 특정 학생 성적보기");
		System.out.println();
		System.out.println(" 5. 프로그램 종료");
		System.out.println();
		System.out.println();
		System.out.print("원하는 메뉴를 선택하세요.(1~4) : ");

		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(s.nextLine());

				if (menu >= 1 && menu <= 4) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
				System.out.print("원하는 메뉴를 선택하세요.(1~4) : ");
				// TODO: handle exception
			}
		} while (true);

		return (menu);
	}// public static int displayMenu(){
		// 데이터를 입력받는 메서드

	static void inputRecord() {
		System.out.println("1. 학생성적 입력하기");
		System.out.println(" '이름,학번,국어석정,영어성적,수학성적'의 순서로 공백없이 입력하세요.");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");

		while (true) {
			System.out.print(">>");
			try {
				String input = s.nextLine().trim();

				if (!input.equalsIgnoreCase("q")) {
					Scanner s2 = new Scanner(input).useDelimiter(",");
					// '이름,학번,국어석정,영어성적,수학성적을 ,로 구분하여 데이터저장

					record.add(new Student2_1(s2.next(), s2.next(), s2.nextInt(), s2.nextInt(), s2.nextInt()));
					System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요.");
				} else {
					return;
				}
			} catch (Exception e) {
				System.out.println("'입력 오류 입니다. 이름,학번,국어성적,영어성적,수학성적'의 순서로 입력하세요.");
			}
		} // do-while(true)
	}// public static void inpurRecord(){

	// 데이털르 삭제하는 메서드
	static void deleteRecord() {
		while (true) {
			displayRecord();
			System.out.println("삭제하고자 하는 데이터의 학번을 입력하세요.(q:메인화면)");
			System.out.print(">>");

			try {
				String input = s.nextLine().trim();
				if (!input.equalsIgnoreCase("q")) {// 입력받은값이 q가 아니면
					int length = record.size();
					boolean found = false;// 파일삭제 성공여부를 확인하는 변수

					for (int i = 0; i < length; i++) {
						Student2_1 student = (Student2_1) record.get(i);
						// record를 0부터 lenght번지까지 검색
						if (input.equals(student.studentNo)) {
							// 입력받은값과 저장된 studentNO가 같으면
							found = true;// 파일이 삭제됬음을 알리기 위해true로바꿈
							record.remove(i);// recorde의 해당 번지(i)의 값을 삭제한다.
							break;
						}
					} // for(int i=0;i<length;i++ {
					if (found) {
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("일치하는 데이터가 없습니다.");
					}
				} else {
					return;
				}
			} catch (Exception e) {
				System.out.println("입력오류입니다. 다시 입력해주세요.");
			}

		} // end of while
	}// public static void deleteRecord(){

	// 데이터를 정렬하는 메서드
	static void sortRecord() {
		while (true) {
			System.out.print("정렬기준을 선택하세요.(1:이름순, 2:성적순 ,3:메인메뉴)");
			int sort = 0;
			do {
				try {
					sort = Integer.parseInt(s.nextLine());

					if (sort >= 1 && sort <= 3) {
						break;
					} else {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("유효하지 않은 입력값입니다. 다시 입력해주세요.");
					System.out.print("정렬기준을 선택하세요.(1:이름순, 2:성적순, 3:메인메뉴");
				}
			} while (true);

			if (sort == 1) {
				Collections.sort(record, new NameAscending2());
				displayRecord();
				// 배열을 이름순으로 정렬하고 displayRecord로 출력
			} else if (sort == 2) {
				Collections.sort(record, new TotalDescending2());
				displayRecord();
				// 배열을 성적순으로 정렬하고 displayRecord로 출력
			} else {
				return;
			}
		} // while(true)
	}

	// 특정학생 점수출력
	static void printSpecificStudent() {
		while (true) {

			System.out.println("출력할 학생의 학번을 입력하세요.(q:메인화면)");
			System.out.print(">>");
			try {
				String input = s.nextLine().trim();
				if (!input.equalsIgnoreCase("q")) {// 입력받은값이 'q''Q'가아니면
					int length = record.size();
					boolean found = false;

					for (int i = 0; i < length; i++) {// 입력된 학생의 수만큼
						Student2_1 student = (Student2_1) record.get(i);
						// record배열에서 얻은정보로student객체를 생성
						if (input.equals(student.studentNo)) {
							// 입력받은값과 생성된 student객체의 studentNo이 같으면
							found = true;
							System.out.println();
							System.out.println("이름  번호 국어  영어  수학    총점    평균");
							System.out.println("==========================================");
							System.out.println(student);// student 객체를 출력!
							System.out.println();
							break;
						}
					} // for(int i=0;i<length;i++ {
					if (found) {
						// System.out.println("출력되었습니다.");
					} else {
						System.out.println("일치하는 데이터가 없습니다.");
					}
				} else {
					return;
				}
			} catch (Exception e) {
				System.out.println("입력오류입니다. 다시 입력해주세요.");
			}

		} // end of while
	}// printStudent()

	// 데이터 목록을 보여주는 메서드
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int average = 0;

		System.out.println();
		System.out.println("이름  번호 국어  영어  수학    총점    평균");
		System.out.println("==========================================");

		int length = record.size();

		if (length > 0) {
			for (int i = 0; i < length; i++) {
				Student2_1 student = (Student2_1) record.get(i);// 학생수만큼 객체생성
				System.out.println(student);// 생성된 객체 출력
				koreanTotal += student.koreanScore;// 객체마다 koreanScore값을
													// koreanTotal에 더한다.
				mathTotal += student.mathScore;
				englishTotal += student.englishScore;
				total += student.total;
				average += student.average;
			}
		} else {
			System.out.println();
			System.out.println("데이터가 없습니다.");
			System.out.println();
		}
		System.out.println("==========================================");
		System.out.println("총점 : " + Student2_1.format(koreanTotal + "", 11, Student2_1.CENTER)
				+ Student2_1.format(englishTotal + "", 6, Student2_1.CENTER)
				+ Student2_1.format(mathTotal + "", 6, Student2_1.CENTER)
				+ Student2_1.format(total + "", 8, Student2_1.CENTER)
				+ Student2_1.format(average/record.size() + "", 8, Student2_1.CENTER));

		System.out.println();
	}// static void displayRecord(){
}// end of class

// 이름을 오름차순(가나다순)으로 정렬하는데 사용되는 클래스
class NameAscending2 implements Comparator {// comparable 기본정렬 //comparator 임의의
											// 정렬 구현
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student2_1 && o2 instanceof Student2_1) {
			Student2_1 s1 = (Student2_1) o1;
			Student2_1 s2 = (Student2_1) o2;

			return (s1.name).compareTo(s2.name);
		}
		return -1;
	}
}

// 평균을 내림차순(큰값에서 작은값)으로 정렬하는데 사용되는 클래스
class TotalDescending2 implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student2_1 && o2 instanceof Student2_1) {
			Student2_1 s1 = (Student2_1) o1;
			Student2_1 s2 = (Student2_1) o2;

			return (s1.average < s2.average) ? 1 : (s1.average == s2.average ? 0 : -1);
			// s1.average이 s2.average.보다 작으면 1출력 크면
			// (s1.average == s2.average ? 0 : -1)실행
			// s1.average과 s2.average이 같으면 0 다르면 -1;
		}
		return -1;
	}
}

class Student2_1 implements Comparable {
	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;

	String name = "";
	String studentNo = "";
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;
	int total = 0;
	int average = 0;

	Student2_1(String name, String studentNo, int koreanScore, int mathScore, int englishScore) {
		this.name = name;
		this.studentNo = studentNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		total = koreanScore + mathScore + englishScore;
		average = total / 3;
	}

	public String toString() {
		return format(name, 4, LEFT) + format(studentNo, 4, RIGHT) + format("" + koreanScore, 6, RIGHT)
				+ format("" + mathScore, 6, RIGHT) + format("" + englishScore, 6, RIGHT) + format("" + total, 8, RIGHT)
				+ format("" + average, 8, RIGHT);
	}

	static String format(String str, int length, int alignment) {
		int diff = length - str.length();
		if (diff < 0)
			return str.substring(0, length);

		char[] source = str.toCharArray();
		char[] result = new char[length];

		// 배열 result를 공백으로 채운다.
		for (int i = 0; i < result.length; i++) {
			result[i] = ' ';
		}

		switch (alignment) {
		case CENTER:
			System.arraycopy(source, 0, result, diff / 2, source.length);

			break;
		case RIGHT:
			System.arraycopy(source, 0, result, diff, source.length);
			break;

		case LEFT:
		default:
			System.arraycopy(source, 0, result, 0, source.length);

		}
		return new String(result);
	}// static String format(String str,int
		// length,int alignment){

	public int compareTo(Object obj) {
		int result = -1;
		if (obj instanceof Student2_1) {
			Student2_1 tmp = (Student2_1) obj;
			result = (this.name).compareTo(tmp.name);
		}
		return result;
	}
}// class Student2 implements Comparable{
