package Day10_160111;

public class StringEx3 {
	public static void main(String[] args) {

		String s1 = "AAA";
		String s2 = new String("AAA");
		if (s1 == s2)

		{
			System.out.println("s1==s2 ? true");
		} else

		{
			System.out.println("s1==s2 ? false");
		}

		s2 = s2.intern();// constant pool�� ���ڿ� �Է����� �̹� constant pool�� �Էµ� ���ڿ��̸�
							// �� �ּҰ��� ����Ű�Եȴ�
		// �� s1�� ���� constant pool�� ����Ǿ������Ƿ� s2�� s1�� �ּҰ��� ���Եȴ�. ���� s1�� s2�� ����
		// �ּҰ��� ����Ų��.
		System.out.println("s2�� intern()�� ȣ���� ��");

		if (s1 == s2) {
			System.out.println("s1==s2 ? true");
		} else {
			System.out.println("s1==s2 ? false");
		}
	}
}
