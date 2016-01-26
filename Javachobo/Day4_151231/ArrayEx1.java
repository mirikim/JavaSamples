package Day4_151231;

public class ArrayEx1 {
	public static void main(String[] args) {
		int sum = 0; // ������ �����ϱ� ���� ����
		float average = 0f;// ����� �����ϱ� ���� ����

		int[] score = { 100, 88, 100, 100, 90 }; // score.length = 5
		for (int i = 0; i < score.length; i++) {
			sum += score[i];// sum = sum + score[i];
		}

		average = sum / (float) score.length;// ������� float�� ��� ���� casting

		System.out.println("���� : " + sum);
		System.out.println("��� : " + average);
	}
}
