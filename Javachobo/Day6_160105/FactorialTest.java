package Day6_160105;

public class FactorialTest {
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}

	static long factorial(int n) {
		long result = 0;
		if (n == 1) {
			result = 1;
		} else {
			result = n * factorial(n - 1);
		}
		return result;
		// return (n==1)?1:n*factorial(n-1);
	}
}
