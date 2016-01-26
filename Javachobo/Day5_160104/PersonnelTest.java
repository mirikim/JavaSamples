package Day5_160104;

//메소드 이름은 동사로 멤버속성은 명사형으로쓴다.
class Personnel {

	int employeeNumber;
	String name;
	int age;
	String responsibility;
	String department;
	boolean working;

	void work() {
		working = !working;
		if (working == true) {
			System.out.println("업무시간입니다.");
		} else if (working == false) {
			System.out.println("업무시간이 끝났습니다.");
		}

	}

	void promote() {
		System.out.println("진급!");
	}

}

public class PersonnelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnel p = new Personnel();

		System.out.println("초기값출력: 이름 = " + p.name + " 나이 = " + p.age + " 직급 = " + p.responsibility + " 사번 = "
				+ p.employeeNumber + " 부서 =" + p.department);

		p.name = "김미리";
		p.age = 25;
		p.responsibility = "대리";
		p.employeeNumber = 20160104;
		p.department = "개발팀";

		System.out.println("=========================================================================");

		System.out.println("이름 = " + p.name + " 나이 = " + p.age + " 직급 = " + p.responsibility + " 사번 = "
				+ p.employeeNumber + " 부서 = " + p.department);

		p.work();
		p.promote();

	}

}
