package Day6_160105;

class Student {
	String name;
	static int ban = 0, no = 0, kor, eng, math;
	static int total = 0;

	{
		++no;
	}

	Student(String name) {
		++ban;
		++no;
		this.name = name;
		System.out.println("�̸� : " + " " + this.name + " " + ban + "��" + " " + no + "��");
	}

	void getTotal(int kor, int eng, int math) {

		total = kor + eng + math;
		System.out.print("�հ� :  " + total + "�� , ");
		getAverage();
	}

	static void getAverage() {
		int average = 0;
		average = total / 3;
		System.out.println("��� : " + average + "��");
	}
}

public class StudentTest {
	public static void main(String[] args) {

		Student s1 = new Student("��̸�");
		s1.getTotal(100, 50, 82);
		System.out.println("");

		Student s2 = new Student("ȫ�浿");
		s2.getTotal(60, 80, 90);
		System.out.println("");

		Student s3 = new Student("���ҿ�");
		s3.getTotal(100, 99, 98);
		System.out.println("");
	}
}
