package Day3_151230;

public class FlowEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 82;
		String grade = "";
		System.out.println(" 당신의 점수는 " + score + " 입니다.");
		if (score >= 90) {// score가 90점 보다 같거나 크면 A학점
			grade = "A";
			if (score >= 98) {// 90점 이상 중에서도 98점 이상은 A+
				grade += "+"; // grade = grade + "+";와 같다.
			} else if (score < 94) {
				grade += "-";
			}
		} else if (score >= 80) {// score가 80점보다 같거나 크면 B학점
			grade = "B";
			if (score >= 88) {
				grade += "+";

			} else if (score < 84) {
				grade += "-"; // grade = grade+"+"
			}
		} else {
			grade = "C"; // 나머지는 C학점(grade)
		}
		System.out.println(" 당신의 학점은 " + grade + " 입니다.");
	}

}
