package Day13_160114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GradeHashMap {

	static HashMap subStudent = new HashMap();
	static HashMap HashAvg = new HashMap();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		MainLoop: while (true) {
			try {
				System.out.println("============= 프로그램 시작 =============");
				System.out.print("학생수를 입력하세요 : ");
				int inputStudentNum = Integer.parseInt(in.readLine());
				String[] subject = { "국어", "영어", "수학" };
				for (int i = 0; i < inputStudentNum; i++) {

					System.out.print((i + 1) + "번째 학생이름 : ");

					String inputName = in.readLine();

					for (int j = 0; j < subject.length; j++) {
						inputScoreLoop: while (true) {
							System.out.print(subject[j] + "점수 : ");

							int inputScore = Integer.parseInt(in.readLine());

							if (inputScore >= 0 && inputScore <= 100) {
								addStudent(inputName, subject[j], inputScore);
								break inputScoreLoop;
							} else {
								System.out.println("점수의 범위는 0~100입니다. 다시입력해주세요");
							}
						}
					}

				}
				System.out.println();

				StudentScore();

				Set set = HashAvg.entrySet();
				// TreeMap에 저장된 키와 값을 키와 값의 결합된 형태로 Set에 저장해서반환
				List list = new ArrayList(set);// ArrayList(Collection c)

				// static void sort(List list, Comparaotr c)
				Collections.sort(list, new ValueComparator());

				Iterator it = list.iterator();

				System.out.println("전체 석차 :");// 내림차순
				int grade = 1;
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					int value = ((Integer) entry.getValue()).intValue();
					System.out.print(grade + "등 " + entry.getKey() + " (평균 : " + value + ")  ");
					if (grade % 3 == 0)
						System.out.println();
					grade++;
				}
				System.out.println("");

				break MainLoop;
			} catch (Exception e) {
				System.out.println("에러입니다. 프로그램을 다시 시작합니다.");
			}
		} // MainLoop
		System.out.println("============= 프로그램 종료 =============");

	}// main

	// 그룹을 추가하는 메서드{
	static void addName(String studentName) {
		if (!subStudent.containsKey(studentName))// phoneBook에 같은 groupName이 없다면
			subStudent.put(studentName, new HashMap());
		// phoneBook에 입력받은groupName과 HashMap()을 put한다
		// HashMap()자체도 Value값으로 저장될 수 있다.
	}

	// 그룹에 학생정보를 추가하는 메서드
	static void addStudent(String studentName, String subject, int score) {
		addName(studentName);
		HashMap addScore = (HashMap) subStudent.get(studentName);
		addScore.put(subject, score);
	}

	// 학생평균을 저장메서드{
	static void addAvg(String studentName, int scoreAvg) {

		HashAvg.put(studentName, scoreAvg);
		if (!HashAvg.containsKey(studentName)) {
			HashAvg.put(studentName, scoreAvg);
		}

	}

	// 학생 전체를 출력하는 메서드
	static void StudentScore() {
		Set set = subStudent.entrySet();
		Iterator it = set.iterator();
		int TotalAvg = 0;
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println("이름 : " + e.getKey());
			int studentTotal = 0;
			int studentAvg = 0;
			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();

				String subject = (String) subE.getKey();
				int score = (Integer) subE.getValue();
				System.out.print(subject + "점수 : " + score + " ");

				studentTotal += score;
				studentAvg = (studentTotal) / subSet.size();

			}
			System.out.println("합계 : " + studentTotal + ", 평균 : " + studentAvg);
			addAvg((String) e.getKey(), studentAvg);
			System.out.println();
			TotalAvg += studentAvg;
		}
		System.out.println("전체 평균 : " + TotalAvg);
	}// StudentScore()

	static class ValueComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;

				int v1 = ((Integer) e1.getValue()).intValue();
				int v2 = ((Integer) e2.getValue()).intValue();

				return v2 - v1;

			}
			return 0;
		}
	}// static class ValueComparator implements Comparator{

}// class
