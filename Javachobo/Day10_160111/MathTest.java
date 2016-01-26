package Day10_160111;

public class MathTest {
	public static void main(String[] args) {
		int i = Math.abs(-10);
		double d = Math.abs(-10.0);
		System.out.println("i : " + i + " , d : " + d);
		
		double d1 = Math.ceil(10.1);
		double d2 = Math.ceil(-10.1);
		double d3 = Math.ceil(10.000015);
		System.out.println("d1 = " + d1 +", d2 = " + d2 + " , d3 = " +d3);
		
		
	}
}
