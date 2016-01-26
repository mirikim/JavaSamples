package HomeWorkhb;

import java.io.*;
import java.util.*;


public class GradeHashMap_4 {
	static HashMap student = new HashMap<>(); // �̸�- ����
	static HashMap avgHashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);

		System.out.print("�л� ���� �Է��ϼ��� : ");
		int count = s.nextInt();

		for (int i = 0; i < count; i++) {

			System.out.print("�̸��� �Է��ϼ���. : ");
			String name = in.readLine();

			System.out.print("���� ������ �Է��ϼ��� : ");
			int scoreKor = s.nextInt();

			System.out.print("���� ������ �Է��ϼ��� : ");
			int scoreEng = s.nextInt();

			System.out.print("���� ������ �Է��ϼ��� : ");
			int scoreMath = s.nextInt();

			addScore(name, "����", scoreKor);
			addScore(name, "����", scoreEng);
			addScore(name, "����", scoreMath);
		}

		printList();

		Set set = avgHashMap.entrySet();
		List list = new ArrayList<>(set);

		Collections.sort(list, new ValueComparator());

		Iterator avgIt = set.iterator();
		int i = 1;
		
		System.out.println();
		System.out.println(" * ��� ������ ����մϴ� * ");
		while (avgIt.hasNext()) {
			Map.Entry e = (Map.Entry) avgIt.next();
			String name = (String) e.getKey();
			int avg = (Integer) e.getValue();

			System.out.println(i + "�� | �̸� : " + name + ", ��� : " + avg);
			++i;
		}
		System.out.println();
	}

	// �׷��� �߰��ϴ� �޼���
	static void addName(String studentName) {
		if (!student.containsKey(studentName)) // groupName�� phoneBook�� key ������
												// ���ԵǾ����� ������(!)

			// groupName�� phoneBook�ȿ� ���ο� HashMap�� ����� �ű⿡ ����
			student.put(studentName, new HashMap());
	}

	// ������ �߰��ϴ� �޼���
	static void addScore(String studentName, String subName, int score) {
		addName(studentName); // �׷� �߰�
		HashMap subNameGroup = (HashMap) student.get(studentName); // ������
		// groupName(key)��
		// ���� ��ȯ�Ѵ�
		subNameGroup.put(subName, score); // �̸��� �ߺ����� = ��ȭ��ȣ�� key������ �Ѵ�
	}

	static void printList() {
		Set set = student.entrySet(); // student�� ��ü key,value ������
		// name - score(subname-subscore)
		Iterator it = set.iterator(); // ���� set�� �����ϴ� iterator

		System.out.println();
		System.out.println(" * �Է��� �л��� ������ ����մϴ� *");
		System.out.println("  �̸� | ���� | ���� | ���� | ���� | ���");

		while (it.hasNext()) { // ���� ��Ұ� ���� �� ���� �ݺ�

			int total = 0;

			Map.Entry e = (Map.Entry) it.next(); // ���� ��Ұ� �ִ��� Ȯ��
			// Map.Entry e �� �޾ƿ� ��(e.getValue)�� HashMap���� ����ȯ ���ְ�
			// �ٽ� �� subHashMap�� entrySet()�� �����´�.
			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator(); // subHashMap ����

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