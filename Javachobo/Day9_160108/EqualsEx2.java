package Day9_160108;

class Person {
	long id;

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			return id == ((Person) obj).id;// obj가 Object타입이므로 id값을 참고하기 위해서는
											// Person타입으로 형변환이 필요.
		} else {
			return false;// 타입이 Person이 아니면 값을 비교할 필요도 없다.
		}
	}

	Person(long id) {
		this.id = id;
	}
}

public class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if (p1 == p2) {// 참조형변수끼리 주소값을 비교
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		if (p1.equals(p2)) {// Person에서 오버라이딩한 equals메소드(6라인)에서 return 값을 해당주소에
							// 있는 값을 비교하도록 설정해놨기에
			// p1과 p2가 참고하는 주소의 실제 값을 비교한다.
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}

	}
}
