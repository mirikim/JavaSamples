package HomeWorkhb;

import java.io.*;
import java.util.*;


public class GradeHashMap_4 {
	static HashMap student = new HashMap<>(); // 이름- 성적
	static HashMap avgHashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);

		System.out.print("학생 수를 입력하세요 : ");
		int count = s.nextInt();

		for (int i = 0; i < count; i++) {

			System.out.print("이름을 입력하세요. : ");
			String name = in.readLine();

			System.out.print("국어 성적을 입력하세요 : ");
			int scoreKor = s.nextInt();

			System.out.print("영어 성적을 입력하세요 : ");
			int scoreEng = s.nextInt();

			System.out.print("수학 성적을 입력하세요 : ");
			int scoreMath = s.nextInt();

			addScore(name, "국어", scoreKor);
			addScore(name, "영어", scoreEng);
			addScore(name, "수학", scoreMath);
		}

		printList();

		Set set = avgHashMap.entrySet();
		List list = new ArrayList<>(set);

		Collections.sort(list, new ValueComparator());

		Iterator avgIt = set.iterator();
		int i = 1;
		
		System.out.println();
		System.out.println(" * 평균 석차를 출력합니다 * ");
		while (avgIt.hasNext()) {
			Map.Entry e = (Map.Entry) avgIt.next();
			String name = (String) e.getKey();
			int avg = (Integer) e.getValue();

			System.out.println(i + "등 | 이름 : " + name + ", 평균 : " + avg);
			++i;
		}
		System.out.println();
	}

	// 그룹을 추가하는 메서드
	static void addName(String studentName) {
		if (!student.containsKey(studentName)) // groupName이 phoneBook의 key 값으로
												// 포함되어있지 않으면(!)

			// groupName을 phoneBook안에 새로운 HashMap을 만들어 거기에 저장
			student.put(studentName, new HashMap());
	}

	// 점수를 추가하는 메서드
	static void addScore(String studentName, String subName, int score) {
		addName(studentName); // 그룹 추가
		HashMap subNameGroup = (HashMap) student.get(studentName); // 지정된
		// groupName(key)의
		// 값을 반환한다
		subNameGroup.put(subName, score); // 이름은 중복가능 = 전화번호를 key값으로 한다
	}

	static void printList() {
		Set set = student.entrySet(); // student의 전체 key,value 가져옴
		// name - score(subname-subscore)
		Iterator it = set.iterator(); // 위의 set을 참조하는 iterator

		System.out.println();
		System.out.println(" * 입력한 학생의 성적을 출력합니다 *");
		System.out.println("  이름 | 국어 | 영어 | 수학 | 총점 | 평균");

		while (it.hasNext()) { // 다음 요소가 있을 때 까지 반복

			int total = 0;

			Map.Entry e = (Map.Entry) it.next(); // 다음 요소가 있는지 확인
			// Map.Entry e 로 받아온 값(e.getValue)를 HashMap으로 형변환 해주고
			// 다시 그 subHashMap의 entrySet()을 가져온다.
			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator(); // subHashMap 참조

			System.out.print(e.getKey());

			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String subName = (String) subE.getKey();
				int score = (int) subE.getValue();
				total += score;

				System.out.print(" |  " + score);
				// System.out.println(e.getKey() + " " + subName + " " + score);
			}
			int avg = (int) total / subSet.size();

			System.out.print(" |  " + total + " |  " + avg);
			System.out.println();

			addAvg((String) e.getKey(), avg);
		}
	}

	static void addAvg(String name, int avg) {
		if (student.containsKey(name)) {
			avgHashMap.put(name, avg);
		}
	}

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

	}

}