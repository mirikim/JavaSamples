package Day6_160105;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student2 {
	String name;
	int ban = (int) (Math.random() * 10);
	int no = (int) (Math.random() * 45);
	static int kor, eng, math;
	static int total = 0;

	Student2(String name) {
		++ban;
		++no;
		this.name = name;
		System.out.println(" ");
		System.out.println("이름 : " + this.name + " " + ban + "반" + " " + no + "번");
	}

	void getTotal(int kor, int eng, int math) {

		total = kor + eng + math;
		System.out.print("합계 : " + total + "점 , ");
		getAverage();
	}

	static void getAverage() {
		int average = 0;
		average = total / 3;
		System.out.println("평균 : " + average + "점");
	}
}

public class StudentTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력받을 학생의 수를 입력해주세요 : ");
		int j = Integer.parseInt(in.readLine());
		for (int i = 0; i < j; i++) {
			System.out.print("학생의 이름을 입력해주세요 : ");
			String studentName = in.readLine();

			System.out.print("국어 점수를 입력해주세요 : ");
			Student.kor = Integer.parseInt(in.readLine());
			System.out.print("영어 점수를 입력해주세요 : ");
			Student.eng = Integer.parseInt(in.readLine());
			System.out.print("수학 점수를 입력해주세요 : ");
			Student.math = Integer.parseInt(in.readLine());

			Student s1 = new Student(studentName);
			s1.getTotal(Student.kor, Student.eng, Student.math);
			System.out.println("");
		}
	System.out.println("====================================");
	}
}
