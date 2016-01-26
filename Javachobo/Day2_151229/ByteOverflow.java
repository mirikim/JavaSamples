package Day2_151229;

public class ByteOverflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 0;
		int i = 0;
		//반복문을 이용해서 b의 값을 1씩,0부터 270까지 증가
		for (int x = 0; x <= 270; x++) {
			System.out.print(b++); //print는 출력 후 줄바꿈을 하지 않는다.
			System.out.print('\t');//tab을 출력
			System.out.println(i++);
		}
	}

}
