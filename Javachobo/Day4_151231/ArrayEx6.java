package Day4_151231;

public class ArrayEx6 {
	public static void main(String[] args) {
		int []number = new int[10];
		int []counter = new int[10];
		
		for(int i=0;i<number.length;i++){
			System.out.print(number[i]=(int)(Math.random()*10));//number[i]라는 배열에 랜덤값을 입력
		}
		System.out.println();
		
		for(int i =0;i<number.length;i++){
			counter[number[i]]++;//i의 갯수를 counter[i]배열에 입력
		}
		for(int i=0;i<counter.length;i++){
			System.out.println(i+"의 개수 :"+counter[i]);
		}
	}
}
