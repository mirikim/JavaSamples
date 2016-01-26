package Day2_151229;

public class OperatorEx2 {
	public static void main(String args[]) {
		int i = 5;
		int j = 0;
		j = i++;
		System.out.println("j=i++;실행후, i=" + i + ", j=" + j);

		i = 5;	//결과를 비교하기 위해,i와j의 값을 다시 5와 0으로 변경
		j = 0;
		j = ++i;
		System.out.println("j=++i;실행후, i=" + i + ", j=" + j);

	}
}
