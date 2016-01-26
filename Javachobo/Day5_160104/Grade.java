package Day5_160104;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

public class Grade {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String student[] = { "김미리", "박보검", "이동휘", "류준열", "고경표" };
		String subname[] = { "java", "jsp", "Database", "android" };

		int score[][] = new int[student.length][subname.length];

		int javaTotal = 0;
		int jspTotal = 0;
		int DatabaseTotal = 0;
		int androidTotal = 0;

		for (int k = 0; k < score.length; k++) {

			System.out.println(student[k] + "의 성적입력");

			for (int i = 0; i < score[k].length; i++) {
				System.out.print(subname[i] + "=");
				score[k][i] = Integer.parseInt(in.readLine());
			}
		}

		System.out.println("      java jsp Db android ||  합계  평균");
		System.out.println("===========================================");
		for (int i = 0; i < score.length; i++) {
			int sum = 0;
			javaTotal += score[i][0];
			jspTotal += score[i][1];
			DatabaseTotal += score[i][2];
			androidTotal += score[i][3];
			System.out.print(student[i] + "  ");
			for (int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.print(score[i][j] + "  ");
			}
			System.out.println("  ||  " + sum + "   " + sum / (float) score[i].length);
		}
		System.out.println("===========================================");
		System.out.println("합 계 : " + javaTotal + " " + jspTotal + " " + DatabaseTotal + " " + androidTotal);
	}

}
