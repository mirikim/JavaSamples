package Day10_160111;

public class StringBufferTest {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		System.out.println(sb);

		int bufferSize = sb.capacity();
		System.out.println(bufferSize);

		StringBuffer sb1 = new StringBuffer("StringBuffer");
		StringBuffer sb2 = sb1.append("Test");
		System.out.println("StringBuffer sb2 = sb1.append(\"Test\");을 실행 : " + sb2);
		sb1.append('d').append(10.0f);
		StringBuffer sb3 = sb1.append("ABC").append(123);
		System.out.println(
				"sb1.append('d').append(10.0f);와 StringBuffer sb3 = sb1.append(\"ABC\").append(123);을 실행 : " + sb3);

		StringBuffer sb4 = sb3.delete(1, 10);// 1-10번째 삭제
		System.out.println("StringBuffer sb4 = sb3.delete(1, 10);을 실행 : " + sb4);

		StringBuffer sb5 = new StringBuffer("0123456789");
		sb5.deleteCharAt(2);
		System.out.println("sb5.deleteCharAt(2);을 실행 : " + sb5);

		StringBuffer sb6 = new StringBuffer("abcdefg");
		sb6.insert(4, " 123 ");
		System.out.println(sb6);

		int length = sb6.length();
		System.out.println("length의 길이 : " + length);
		
		System.out.println("sb6.reverse = " +sb6.reverse());
		
		sb6.setCharAt(4,'ㄲ');
		System.out.println(sb6);
		
	
		StringBuffer sb7 = new StringBuffer("0123456789");
		sb7.setLength(20);
		String str = sb7.toString().trim();
		System.out.println(str);
		
		StringBuffer sb8 = new StringBuffer("kimmiri");
		String str1 = sb8.substring(3);
		System.out.println(str1);
	}
}
