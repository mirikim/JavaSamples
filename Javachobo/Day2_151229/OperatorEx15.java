package Day2_151229;

public class OperatorEx15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'a';
		for(int i=0; i<26;i++){	//��{}���� ������ 26���� �ݺ� , i = iteration(�ݺ�)
			System.out.print(c++); //'a'���� 26���� ���ڸ� ����Ѵ�.
		}
		System.out.println();//�ٹٲ��� �Ѵ�.	
		
		c ='A';
		for(int i=0;i<26;i++){		//��{}���� ������ 26���� �ݺ�
			System.out.print(c++);//'A'���� 26���� ���ڸ� ����Ѵ�.
		}
		System.out.println();
		
		c='0';
		for(int i=0; i<10;i++){	//��{}���� ������ 10���� �ݺ�
			System.out.print(c++);	//'0'����10���� ���ڸ� ����Ѵ�.
		}
		System.out.println();
	}

}
