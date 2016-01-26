package Day3_151230;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		cal: while (true) {
			System.out.println("계산기를 선택하세요 '1':진수변환 , '2':사칙연산, '0': 종료");
			int calnum = scan.nextInt();
			switch (calnum) {
			case 0:
				System.out.println("계산기를 이용해 주셔서 감사합니다.");
				break cal;
			case 1:
				Loop1: while (true) {
					
						System.out.println(" 2진수->10진수 : 'a' , 10진수->2진수 : 'b'");

						int digitnum = System.in.read();

						switch (digitnum) {

						case 'a': {
							System.out.println("변경할 2진수를 입력해주세요");

							String binarynum = scan.next();
							System.out.println(binarynum + "을 10진수로 변경한 값은 =" + Integer.valueOf(binarynum, 2));
							System.out.println("");

							break Loop1;
						}
						case 'b': {
							System.out.println("변경할 10진수를 입력해주세요");
							int decimalnum = scan.nextInt();
							System.out.println(decimalnum + "을 2진수로 변경한 값은 = " + Integer.toBinaryString(decimalnum));
							System.out.println("");
							break Loop1;
						}
						default:
							System.out.println("해당 연산은 없습니다.'a' 또는 'b'를 입력해주세요.");
							System.out.println("");

						//	break;

						
					}
					// break;
				}
			case 2: {
				Loop2: while (true) {
					System.out.println("첫번째 수를 입력하세요.");

					int number1 = scan.nextInt();

					System.out.println("두번째 수를 입력하세요.");

					int number2 = scan.nextInt();

					System.out.println("연산자 * , + , - , / 를 입력하세요");
					int op = System.in.read();

					switch (op) {
					case '*':
						System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
						break Loop2;

					case '+':
						System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
						break Loop2;
					case '-':
						System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
						break Loop2;
					case '/':
						System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
						break Loop2;
					default:
						System.out.println("계산이 불가한 연산자입니다. 연산자를 다시 입력해주세요");

						break;
					}

				}
				break;
			}

			default:
				System.out.println("해당 계산기는 없습니다. 계산기를 다시 선택해주세요.");
				break;

			}
		}
	}

}
