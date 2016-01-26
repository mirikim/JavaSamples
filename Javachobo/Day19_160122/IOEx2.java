package Day19_160122;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

public class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] temp = new byte[10];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		input.read(temp, 0, temp.length);// �о� �µ����и� �迭 temp�� ��´�.
		output.write(temp, 5, 5);// temp[5]���� 5���� �����͸� write�Ѵ�.

		outSrc = output.toByteArray();

		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp         : " + Arrays.toString(temp));
		System.out.println("Output Sourc : " + Arrays.toString(outSrc));
	}
}
