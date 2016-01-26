package Day10_160111;

public class WrapperEx1 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println("i == i2 ? " + (i == i2));
		//i와i2의 주소값이 다르므로
		System.out.println("i.equals(i2) ? " + i.equals(i2));
		//equals()오버라이딩하여 실제값을 비교
		System.out.println("i.toString() = " + i.toString());

		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("SIZE = " + Integer.SIZE + "bits");//8x4
		System.out.println("TYPE = " + Integer.TYPE);
	}
}
