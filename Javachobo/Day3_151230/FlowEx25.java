package Day3_151230;

public class FlowEx25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 1;
		while (true) {
			if (sum > 100)
				break;
			sum += i;
			i++;
		} // end of while
		System.out.println("i=" + i);
		System.out.println("sum=" + sum);
	}

}
